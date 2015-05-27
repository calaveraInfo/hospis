package cz.cestadomu.hospis.core.lib.routes;

import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.camel.Consume;
import org.apache.camel.Header;
import org.apache.camel.RecipientList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Component
public class MainRouter {

	private static final Logger log = LoggerFactory.getLogger(MainRouter.class);

	public static final String ROUTE_TO_HEADER_NAME = "routeTo";

	/**
	 * SEDA is used instead of direct because the controll messages are sent
	 * also during application context initialization when this listener might
	 * not be initialized yet.
	 */
	public static final String DYNAMIC_ROUTER_CONTROLL_CHANNEL = "seda:dynamicRouter";

	private List<RoutingItem> routes = new LinkedList<MainRouter.RoutingItem>();

	final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@RecipientList
	@Consume(uri = InboundGateway.XML_MESSAGE_CHANNEL)
	public String route(Document body) {
		log.debug("Routing message.");
		for (RoutingItem routingItem : routes) {
			try {
				routingItem.getValidator().validate(new DOMSource(body));
				log.debug("Route {} accepts message.", routingItem.routeTo);
				return routingItem.getRouteTo();
			} catch (Exception e) {
				log.trace("Route {} doesn't accept message.", routingItem.routeTo, e);
			}
		}
		throw new RuntimeException("No route for a message!");
	}

	@Consume(uri = DYNAMIC_ROUTER_CONTROLL_CHANNEL)
	public void recieveRoutingUpdate(@Header(ROUTE_TO_HEADER_NAME) String routeTo, Document schema) {
		log.info("Recieved dynamic routing configuration message.");
		synchronized (routes) {
			routes.add(new RoutingItem(routeTo, schema));
		}
	}

	private class RoutingItem {
		private String routeTo;
		private Validator validator;

		public RoutingItem(String routeTo, Document schema) {
			this.routeTo = routeTo;
			try {
				this.validator = factory.newSchema(new DOMSource(schema)).newValidator();
			} catch (SAXException e) {
				throw new RuntimeException("New route init failed.", e);
			}
		}

		public Validator getValidator() {
			return validator;
		}

		public String getRouteTo() {
			return routeTo;
		}

	}

}

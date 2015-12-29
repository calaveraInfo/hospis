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

import cz.cestadomu.hospis.model.Schema;

@Component
public class MainRouter {

	private static final Logger log = LoggerFactory.getLogger(MainRouter.class);

	public static final String ROUTE_TO_HEADER_NAME = "routeTo";

	/**
	 * SEDA is used instead of direct because the controll messages are sent also during application
	 * context initialization when this router might not be initialized yet.
	 */
	public static final String DYNAMIC_ROUTER_CONTROLL_CHANNEL = "seda:dynamicRouter";

	private final List<RoutingItem> routes = new LinkedList<MainRouter.RoutingItem>();

	final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@RecipientList
	@Consume(uri = InboundGateway.XML_MESSAGE_CHANNEL)
	public String route(final Document body) {

		log.debug("Routing message.");
		for (final RoutingItem routingItem : this.routes) {
			try {
				routingItem.getValidator().validate(new DOMSource(body));
				log.debug("Route {} accepts message.", routingItem.routeTo);
				return routingItem.getRouteTo();
			} catch (final Exception e) {
				log.trace("Route {} doesn't accept message.", routingItem.routeTo, e);
			}
		}
		throw new RuntimeException("No route for a message!");
	}

	@Consume(uri = DYNAMIC_ROUTER_CONTROLL_CHANNEL)
	public void recieveRoutingUpdate(@Header(ROUTE_TO_HEADER_NAME) final String routeTo,
			final String schema) {
		log.info("Recieved dynamic routing configuration message.");
		synchronized (this.routes) {
			this.routes.add(new RoutingItem(routeTo, schema));
		}
	}

	private class RoutingItem {
		private final String routeTo;
		private final Validator validator;

		public RoutingItem(final String routeTo, final String schema) {
			this.routeTo = routeTo;
			try {
				this.validator = factory.newSchema(Schema.valueOf(schema).resourceUrl()).newValidator();
			} catch (final SAXException e) {
				throw new RuntimeException("New route item init failed.", e);
			}
		}

		public Validator getValidator() {
			return this.validator;
		}

		public String getRouteTo() {
			return this.routeTo;
		}

	}

}

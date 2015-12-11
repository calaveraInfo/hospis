package cz.cestadomu.hospis.core.lib.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class InboundGateway extends RouteBuilder {
	public static final String XML_MESSAGE_CHANNEL = "direct:xmlMessage";

	@Override
	public void configure() throws Exception {
		from("activemq:restRequest").to(XML_MESSAGE_CHANNEL).end();
	}
}

package cz.cestadomu.hospis.core.lib.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class InboundGateway extends RouteBuilder {
	public static final String XML_MESSAGE_CHANNEL = "direct:xmlMessage";
	public static final String TEST_PIPE = "direct:test";

	@Override
	public void configure() throws Exception {
		from("activemq:restRequest").choice().when(body().startsWith("<?xml")).to(XML_MESSAGE_CHANNEL).otherwise().to(TEST_PIPE).end();
	}
}

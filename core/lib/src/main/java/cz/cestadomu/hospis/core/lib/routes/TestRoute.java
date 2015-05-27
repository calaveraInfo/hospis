package cz.cestadomu.hospis.core.lib.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from(InboundGateway.TEST_PIPE).transform().simple("x${body}");
		// .marshal().jaxb().wireTap("stream:out")
	}
}

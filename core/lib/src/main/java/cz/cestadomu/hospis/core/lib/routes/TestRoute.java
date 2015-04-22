package cz.cestadomu.hospis.core.lib.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("activemq:restRequest").transform().simple("x${body}x");
	}
}

package cz.cestadomu.hospis.core.lib.routes;

import static cz.cestadomu.hospis.core.lib.Transformation.GREETING;
import static cz.cestadomu.hospis.core.lib.Transformation.xslt;
import static cz.cestadomu.hospis.model.Schema.GREETING_SCHEMA;
import static cz.cestadomu.hospis.model.Schema.classpath;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cz.cestadomu.hospis.core.lib.CoreConfiguration;

@Component
public class TestRoute extends RouteBuilder {
	private static final Logger log = LoggerFactory.getLogger(TestRoute.class);

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CoreConfiguration config;

	@Override
	public void configure() throws Exception {
		from(config.getTestChannel()).to(xslt(GREETING));
		// .transform().simple("x${body}");
		// .marshal().jaxb().wireTap("stream:out")
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message for {}.", TestRoute.class);
		this.producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL,
				IOUtils.toString(this.context.getResource(classpath(GREETING_SCHEMA)).getInputStream()),
				MainRouter.ROUTE_TO_HEADER_NAME, config.getTestChannel());
	}
}

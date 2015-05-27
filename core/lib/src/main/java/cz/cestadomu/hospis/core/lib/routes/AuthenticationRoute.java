package cz.cestadomu.hospis.core.lib.routes;

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

@Component
public class AuthenticationRoute extends RouteBuilder {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRoute.class);
	private static final String AUTHENTICATION_CHANNEL = "direct:authentication";

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private ApplicationContext context;

	@Override
	public void configure() throws Exception {
		from(AUTHENTICATION_CHANNEL).transform().constant(Boolean.TRUE);
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message.");
		producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL,
				IOUtils.toString(context.getResource("classpath:/schema/credentials.xsd").getInputStream()), MainRouter.ROUTE_TO_HEADER_NAME,
				AUTHENTICATION_CHANNEL);
	}
}

package cz.cestadomu.hospis.core.lib.routes;

import static cz.cestadomu.hospis.core.lib.Transformation.AUTHENTICATION;
import static cz.cestadomu.hospis.core.lib.Transformation.AUTHENTICATION_RESULT;
import static cz.cestadomu.hospis.core.lib.Transformation.xslt;
import static cz.cestadomu.hospis.model.Schema.CREDENTIALS;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.cestadomu.hospis.core.lib.CoreConfiguration;

@Component
public class AuthenticationRoute extends RouteBuilder {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRoute.class);

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private CoreConfiguration config;

	@Override
	public void configure() throws Exception {
		from(config.getAuthenticationChannel()).to(xslt(AUTHENTICATION)).to(config.getLoginComponent())
				.to(xslt(AUTHENTICATION_RESULT));
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message for {}.", AuthenticationRoute.class);
		this.producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL, CREDENTIALS,
				MainRouter.ROUTE_TO_HEADER_NAME, config.getAuthenticationChannel());
	}

}

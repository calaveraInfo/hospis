package cz.cestadomu.hospis.core.lib.routes;

import static cz.cestadomu.hospis.core.lib.Transform.LOGIN_REQUEST;
import static cz.cestadomu.hospis.core.lib.Transform.LOGIN_RESPONSE;
import static cz.cestadomu.hospis.model.Schema.LOGIN_RESPONSE_SCHEMA;
import static cz.cestadomu.hospis.model.Schema.LOGIN_REQUEST_SCHEMA;

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
		from(config.getAuthenticationChannel()).to(LOGIN_REQUEST_SCHEMA.validator()).to(LOGIN_REQUEST.xslt())
				.to(config.getLoginComponent()).to(LOGIN_RESPONSE.xslt())
				.to(LOGIN_RESPONSE_SCHEMA.validator());
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message for {}.", AuthenticationRoute.class);
		this.producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL,
				LOGIN_REQUEST_SCHEMA.name(), MainRouter.ROUTE_TO_HEADER_NAME, config.getAuthenticationChannel());
	}

}

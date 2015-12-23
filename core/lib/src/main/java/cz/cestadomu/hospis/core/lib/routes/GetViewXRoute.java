package cz.cestadomu.hospis.core.lib.routes;

import static cz.cestadomu.hospis.core.lib.Transformation.EMPLOYEES_RESPONSE_TRANSFORM;
import static cz.cestadomu.hospis.core.lib.Transformation.GET_VIEW_X_REQUEST_TRANSFORM;
import static cz.cestadomu.hospis.core.lib.Transformation.xslt;
import static cz.cestadomu.hospis.model.Schema.GET_VIEW_X_REQUEST;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cz.cestadomu.hospis.core.lib.CoreConfiguration;

@Component
public class GetViewXRoute extends RouteBuilder {
	private static final Logger log = LoggerFactory.getLogger(GetViewXRoute.class);

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CoreConfiguration config;

	@Override
	public void configure() throws Exception {
		from(config.getGetViewXChannel()).to(xslt(GET_VIEW_X_REQUEST_TRANSFORM))
				.to(config.getGetViewXComponent()).to(xslt(EMPLOYEES_RESPONSE_TRANSFORM));
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message for {}.", GetViewXRoute.class);
		producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL,
				GET_VIEW_X_REQUEST, MainRouter.ROUTE_TO_HEADER_NAME, config.getGetViewXChannel());
	}
}

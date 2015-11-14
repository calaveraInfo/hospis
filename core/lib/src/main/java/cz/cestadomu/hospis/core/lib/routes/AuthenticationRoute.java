package cz.cestadomu.hospis.core.lib.routes;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cz.cestadomu.hospis.core.lib.Transformation;
import cz.cestadomu.hospis.model.Schema;

@Component
public class AuthenticationRoute extends RouteBuilder {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationRoute.class);
	protected static final String AUTHENTICATION_CHANNEL = "direct:authentication";

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private ApplicationContext context;
  
  @Value("${endpoint.authentication}")
  private String authenticationChannel;
  
  @Value("${ws.intuo.login}")
  private String loginChannel;

	@Override
	public void configure() throws Exception {
		from(authenticationChannel).to("xslt:" + Transformation.AUTHENTICATION).to(loginChannel).to("xslt:" + Transformation.AUTHENTICATION_RESULT);
	}

	@PostConstruct
	public void sendDynamicRouterConfig() throws IOException {
		log.info("Sending dynamic routing configuration message for {}.", AuthenticationRoute.class);
		this.producerTemplate.sendBodyAndHeader(MainRouter.DYNAMIC_ROUTER_CONTROLL_CHANNEL,
				IOUtils.toString(this.context.getResource("classpath:" + Schema.CREDENTIALS).getInputStream()), MainRouter.ROUTE_TO_HEADER_NAME,
				AUTHENTICATION_CHANNEL);
	}

}

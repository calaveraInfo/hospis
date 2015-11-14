package cz.cestadomu.hospis.core.lib.routes;

import java.io.IOException;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.cestadomu.hospis.core.lib.CoreLibConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreLibConfiguration.class)
@TestPropertySource("classpath:/core-test.properties")
public class AuthenticationRouteTest {

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private ApplicationContext context;
  
  @Value("${endpoint.authentication}")
  private String authenticationChannel;

	@Test
	public void simpleAuthentication() throws CamelExecutionException, IOException {
		/*
		 * this.producerTemplate.sendBody(AuthenticationRoute.AUTHENTICATION_CHANNEL
		 * ,
		 * IOUtils.toString(this.context.getResource("classpath:/credentials.xml"
		 * ).getInputStream()));
		 */
	}
}

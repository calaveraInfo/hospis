package cz.cestadomu.hospis.core.lib.routes;

import static cz.cestadomu.hospis.mock.Mock.CLIENT_LOGIN_REQUEST_MOCK;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;

import cz.cestadomu.hospis.core.lib.CoreConfiguration;
import cz.cestadomu.hospis.core.lib.CoreLib;
import cz.cestadomu.hospis.core.lib.XmlNamespaceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreLib.class)
@TestPropertySource("classpath:/core-test.properties")
@ActiveProfiles("mock")
public class AuthenticationRouteTest {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationRouteTest.class);
	private static final XPath XPATH = XPathFactory.newInstance().newXPath();

	{
		XPATH.setNamespaceContext(new XmlNamespaceContext());
	}

	@Autowired
	private ProducerTemplate producerTemplate;

	@Autowired
	private CoreConfiguration config;

	@Autowired
	private CamelContext context;

	@Test
	public void simpleAuthentication() throws CamelExecutionException, IOException,
			InterruptedException, ExecutionException, XPathExpressionException {

		Document result =
				(Document) producerTemplate.asyncRequestBody(config.getAuthenticationChannel(),
						IOUtils.toString(CLIENT_LOGIN_REQUEST_MOCK.resourceUrl()), Document.class).get();
		assertEquals("true", XPATH.evaluate("/h:authenticationResult/h:authenticated", result));
		assertEquals(
				"YPxdf3NLsE375l5emDP0/8xdMBC1ojiOaB9Sbz1C7QdhrrfwQgu/I+nQbgM7H7WOq2tJae1ZA77DzxdT+EAQuflW/Op8A7zBnQwm5DQ0Ukhqw8TR+IMaCKv5LHP0bCqpv7UK5A==",
				XPATH.evaluate("/h:authenticationResult/h:token", result));
	}
}

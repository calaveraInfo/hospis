package cz.cestadomu.hospis.rest.lib.model;

import static cz.cestadomu.hospis.mock.Mock.CLIENT_LOGIN_REQUEST_MOCK;
import static cz.cestadomu.hospis.model.Schema.LOGIN_REQUEST_SCHEMA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

public class CredentialsTest extends AbstractModelTest<Credentials> {

	@Test
	public void testMarshall() throws XmlMappingException, IOException, SAXException {
		testMarshall(new Credentials("xxx", "yyy"), LOGIN_REQUEST_SCHEMA);
	}

	@Test
	public void testUnmarshall() throws XmlMappingException, IOException {
		Credentials result = testUnmarshall(CLIENT_LOGIN_REQUEST_MOCK);
		assertEquals("frezac", result.getUsername());
		assertEquals("xxx", result.getPassword());
	}
}

package cz.cestadomu.hospis.rest.lib.model;

import static cz.cestadomu.hospis.model.Schema.LOGIN_RESPONSE_SCHEMA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

import cz.cestadomu.hospis.mock.Mock;

public class AuthenticationResultTest extends AbstractModelTest<AuthenticationResult> {

	@Test
	public void testMarshall() throws XmlMappingException, IOException, SAXException {
		testMarshall(new AuthenticationResult(true, "xyz"), LOGIN_RESPONSE_SCHEMA);
	}

	@Test
	public void testUnmarshall() throws XmlMappingException, IOException {
		AuthenticationResult result = testUnmarshall(Mock.CLIENT_LOGIN_RESPONSE_MOCK);
		assertEquals(true, result.isAuthenticated());
		assertEquals(
				"R6TjsXD8+D+B9j9wQRayuLGXUTVduSEdLZzCXRlHR+MlzzijBShZf0WHa0c7HEAbmf1/nkRFko6CxYTUOZolOq5bSnHdDrKIPtHv1k3Z4hFcp8McyKif4DyqIECjhEWrYTCZ3w==",
				result.getToken());
	}
}

package cz.cestadomu.hospis.rest.lib.model;

import static cz.cestadomu.hospis.mock.Mock.CLIENT_GET_VIEW_X_EMPLOYEE_REQUEST_MOCK;
import static cz.cestadomu.hospis.model.Schema.GET_VIEW_X_REQUEST_SCHEMA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

public class GetViewXTest extends AbstractModelTest<GetViewX> {

	@Test
	public void testMarshall() throws XmlMappingException, IOException, SAXException {
		testMarshall(new GetViewX(1234), GET_VIEW_X_REQUEST_SCHEMA);
	}

	@Test
	public void testUnmarshall() throws XmlMappingException, IOException {
		GetViewX result = testUnmarshall(CLIENT_GET_VIEW_X_EMPLOYEE_REQUEST_MOCK);
		assertEquals(1234, result.getViewId());
	}
}

package cz.cestadomu.hospis.model;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import cz.cestadomu.hospis.mock.Mock;

public class SchemaTest {
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SchemaTest.class);

	SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@Test
	public void credentialsTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.LOGIN_REQUEST_SCHEMA.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.CLIENT_LOGIN_REQUEST_MOCK.resourceStream()));
	}

	@Test
	public void employeeTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.GET_OBJECT_INFO_EMPLOYEE_RESPONSE_SCHEMA.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.CLIENT_GET_VIEW_X_EMPLOYEE_RESPONSE_MOCK.resourceStream()));
	}

	@Test
	public void employeesTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.GET_VIEW_X_EMPLOYEES_RESPONSE_SCHEMA.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.CLIENT_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK.resourceStream()));
	}

	/**
	 * This tests if the employees complex type, which is defined in the common imported xsd, doesn't
	 * leak to xsd file wich declares only element employee (not ending with "s").
	 */
	@Test(expected = SAXParseException.class)
	public void transitiveLeakTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.GET_OBJECT_INFO_EMPLOYEE_RESPONSE_SCHEMA.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.CLIENT_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK.resourceStream()));
	}
}

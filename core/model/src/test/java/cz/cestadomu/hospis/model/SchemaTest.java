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
		schemaFactory.newSchema(Schema.CREDENTIALS.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.CREDENTIALS.resourceStream()));
	}

	@Test
	public void employeeTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.EMPLOYEE.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.EMPLOYEE.resourceStream()));
	}

	@Test
	public void employeesTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.EMPLOYEES.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.EMPLOYEES.resourceStream()));
	}

	/**
	 * This tests if the employees complex type, which is defined in the common imported xsd, doesn't
	 * leak to xsd file wich declares only element employee (not ending with "s").
	 */
	@Test(expected = SAXParseException.class)
	public void transitiveLeakTest() throws SAXException, IOException {
		schemaFactory.newSchema(Schema.EMPLOYEE.resourceUrl()).newValidator()
				.validate(new StreamSource(Mock.EMPLOYEES.resourceStream()));
	}
}

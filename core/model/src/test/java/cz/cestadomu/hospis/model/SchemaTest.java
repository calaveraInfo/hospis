package cz.cestadomu.hospis.model;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SchemaTest {
	SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@Test
	public void credentialsSchemaTest() throws SAXException, IOException {
		final Validator validator = this.schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream(Schema.CREDENTIALS))).newValidator();
		validator.validate(new StreamSource(getClass().getResourceAsStream("/credentials.xml")));
	}
}

package cz.cestadomu.hospis.core.lib;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.junit.Test;
import org.xml.sax.SAXException;

public class CoreLibApplicationTests {
	SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@Test
	public void credentialsSchemaTest() throws SAXException, IOException {
		Validator validator = schemaFactory.newSchema(new StreamSource(getClass().getResourceAsStream("/schema/credentials.xsd"))).newValidator();
		validator.validate(new StreamSource(getClass().getResourceAsStream("/credentials.xml")));
	}
}

package cz.cestadomu.hospis.rest.lib.model;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

import cz.cestadomu.hospis.mock.Mock;
import cz.cestadomu.hospis.model.Schema;
import cz.cestadomu.hospis.rest.lib.AbstractTest;

public class AbstractModelTest<T> extends AbstractTest {

	private SchemaFactory schemaFactory =
			SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	@Autowired
	protected Marshaller marshaller;

	@Autowired
	protected Unmarshaller unmarshaller;

	protected void testMarshall(T model, Schema schema) throws SAXException, IOException {
		DOMResult result = new DOMResult();
		marshaller.marshal(model, result);
		schemaFactory.newSchema(schema.resourceUrl()).newValidator()
				.validate(new DOMSource(result.getNode()));
	}

	@SuppressWarnings("unchecked")
	protected T testUnmarshall(Mock mock) throws XmlMappingException, IOException {
		return (T) unmarshaller.unmarshal(new StreamSource(mock.resourceStream()));
	}
}

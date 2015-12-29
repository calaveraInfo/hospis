package cz.cestadomu.hospis.rest.lib.model;

import static cz.cestadomu.hospis.model.Schema.GREETING_SCHEMA;

import java.io.IOException;

import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

public class GreetingTest extends AbstractModelTest<Greeting> {

	@Test
	public void testMarshall() throws XmlMappingException, IOException, SAXException {
		testMarshall(new Greeting("John"), GREETING_SCHEMA);
	}

}

package cz.cestadomu.hospis.rest.lib.model;

import static cz.cestadomu.hospis.mock.Mock.CLIENT_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK;
import static cz.cestadomu.hospis.model.Schema.GET_VIEW_X_EMPLOYEES_RESPONSE_SCHEMA;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.xml.sax.SAXException;

public class EmployeesTest extends AbstractModelTest<Employees> {

	@Test
	public void testMarshall() throws XmlMappingException, IOException, SAXException {
		Employees employees = new Employees();
		employees.getEmployee().add(new Employee(1, "Karel", "Novák", "Čistič"));
		testMarshall(employees, GET_VIEW_X_EMPLOYEES_RESPONSE_SCHEMA);
	}

	@Test
	public void testUnmarshall() throws XmlMappingException, IOException {
		Employees result = testUnmarshall(CLIENT_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK);
		assertEquals(1, result.getEmployee().size());
	}
}

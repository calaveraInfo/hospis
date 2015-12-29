package cz.cestadomu.hospis.rest.lib.gateway;

import cz.cestadomu.hospis.rest.lib.model.Employees;
import cz.cestadomu.hospis.rest.lib.model.GetViewX;

public interface EmployeesGateway {
	public Employees getEmployees(GetViewX request);
}

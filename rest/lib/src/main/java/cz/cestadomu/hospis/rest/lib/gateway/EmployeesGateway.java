package cz.cestadomu.hospis.rest.lib.gateway;

import cz.cestadomu.hospis.model.Employees;
import cz.cestadomu.hospis.model.GetViewX;

public interface EmployeesGateway {
	public Employees getEmployees(GetViewX request);
}

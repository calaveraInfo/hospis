package cz.cestadomu.hospis.rest.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.cestadomu.hospis.model.Employees;
import cz.cestadomu.hospis.model.GetViewX;
import cz.cestadomu.hospis.rest.lib.gateway.EmployeesGateway;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeesGateway employees;

	@RequestMapping(path = "/employees", produces = "application/json")
	public Employees getAllEmployees() {
		GetViewX request = new GetViewX();
		request.setViewId(1707);
		return employees.getEmployees(request);
	}

}

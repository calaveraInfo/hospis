package cz.cestadomu.hospis.rest.lib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"employee"})
@XmlRootElement(name = "employees")
public class Employees implements Serializable {

	protected List<Employee> employee;

	public List<Employee> getEmployee() {
		if (employee == null) {
			employee = new ArrayList<Employee>();
		}
		return this.employee;
	}
}

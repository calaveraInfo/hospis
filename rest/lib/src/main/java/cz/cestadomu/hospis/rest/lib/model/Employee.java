package cz.cestadomu.hospis.rest.lib.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {"id", "firstName", "lastName", "jobDescription"})
public class Employee implements Serializable {

	protected int id;
	@XmlElement(required = true)
	protected String firstName;
	@XmlElement(required = true)
	protected String lastName;
	@XmlElement(required = true)
	protected String jobDescription;

	public Employee() {}

	public Employee(int id, String firstName, String lastName, String jobDescription) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobDescription = jobDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

}

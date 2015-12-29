package cz.cestadomu.hospis.model;

import java.net.URL;

public enum Schema {
	LOGIN_REQUEST_SCHEMA("/schema/login/request.xsd"), //
	LOGIN_RESPONSE_SCHEMA("/schema/login/response.xsd"), //
	GET_VIEW_X_REQUEST_SCHEMA("/schema/getViewX/request.xsd"), //
	GET_VIEW_X_EMPLOYEES_RESPONSE_SCHEMA("/schema/getViewX/employeesResponse.xsd"), //
	GET_OBJECT_INFO_EMPLOYEE_RESPONSE_SCHEMA("/schema/getObjectInfo/employeeResponse.xsd"), //
	GREETING_SCHEMA("/schema/greeting/greeting.xsd");

	public static final String NAMESPACE = "http://www.cestadomu.cz/hospis/model";

	private String path;

	private Schema(String path) {
		this.path = path;
	}

	public String classpath() {
		return "classpath:" + this.path;
	}

	public String validator() {
		return "validator:" + this.path;
	}

	public URL resourceUrl() {
		return Schema.class.getResource(this.path);
	}

	public String path() {
		return this.path;
	}
}

package cz.cestadomu.hospis.model;

import java.net.URL;

public enum Schema {
	CREDENTIALS("/schema/login/request.xsd"), //
	AUTHENTICATION_SCHEMA_RESULT("/schema/login/response.xsd"), //
	GET_VIEW_X_REQUEST("/schema/getViewX/request.xsd"), //
	EMPLOYEES("/schema/getViewX/employeesResponse.xsd"), //
	EMPLOYEE("/schema/getObjectInfo/employeeResponse.xsd"), //
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

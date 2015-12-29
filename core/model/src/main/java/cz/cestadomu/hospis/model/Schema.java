package cz.cestadomu.hospis.model;

import java.net.URL;

public enum Schema {
	CREDENTIALS("/schema/credentials.xsd"), GREETING_SCHEMA("/schema/greeting.xsd"), EMPLOYEE(
			"/schema/employee.xsd"), EMPLOYEES("/schema/employees.xsd"), GET_VIEW_X_REQUEST(
					"/schema/getViewXRequest.xsd"), AUTHENTICATION_SCHEMA_RESULT(
							"/schema/authenticationResult.xsd");

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

package cz.cestadomu.hospis.model;

public class Schema {
	public static final String NAMESPACE = "http://www.cestadomu.cz/hospis/model";
	public static final String CREDENTIALS = "/schema/credentials.xsd";
	public static final String GREETING_SCHEMA = "/schema/greeting.xsd";
	public static final String EMPLOYEE = "/schema/employee.xsd";
	public static final String EMPLOYEES = "/schema/employees.xsd";
	public static final String GET_VIEW_X_REQUEST = "/schema/getViewXRequest.xsd";
	public static final String AUTHENTICATION_SCHEMA_RESULT = "/schema/authenticationResult.xsd";

	public static String classpath(String schema) {
		return "classpath:" + schema;
	}

	public static String validator(String schema) {
		return "validator:" + schema;
	}
}

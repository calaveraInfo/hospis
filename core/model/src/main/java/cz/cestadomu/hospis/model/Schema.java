package cz.cestadomu.hospis.model;

public class Schema {
	public static final String CREDENTIALS = "/schema/credentials.xsd";
	public static final String GREETING_SCHEMA = "/schema/greeting.xsd";
	public static final String EMPLOYEE = "/schema/employee.xsd";
	public static final String EMPLOYEES = "/schema/employees.xsd";
	public static final String GET_VIEW_X_REQUEST = "/schema/getViewXRequest.xsd";

	public static String classpath(String schema) {
		return "classpath:" + schema;
	}
}

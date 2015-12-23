package cz.cestadomu.hospis.mock;

public class Mock {
	public static final String AUTHENTICATION_RESULT = "/authenticationResult.xml";
	public static final String CREDENTIALS = "/credentials.xml";
	public static final String LOGIN_RESPONSE = "/login-response.xml";
	public static final String EMPLOYEE = "/employee.xml";
	public static final String EMPLOYEES = "/employees.xml";
	public static final String EMPLOYEES_RESPONSE = "/employees-response.xml";

	public static String mockClasspath(String mock) {
		return "classpath:" + mock;
	}
}

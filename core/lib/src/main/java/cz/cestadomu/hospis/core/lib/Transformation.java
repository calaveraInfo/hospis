package cz.cestadomu.hospis.core.lib;

public class Transformation {
	public static final String GET_VIEW_X_REQUEST_TRANSFORM = "/transformation/getViewXRequest.xsl";
	public static final String EMPLOYEES_RESPONSE_TRANSFORM = "/transformation/employeesResponse.xsl";
	public static final String AUTHENTICATION = "/transformation/authentication.xsl";
	public static final String AUTHENTICATION_RESULT = "/transformation/authenticationResult.xsl";
	public static final String GREETING = "/transformation/greeting.xsl";

	public static String xslt(String transformation) {
		return "xslt:" + transformation;
	}
}

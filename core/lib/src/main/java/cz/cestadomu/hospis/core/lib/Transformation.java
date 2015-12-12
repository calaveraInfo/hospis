package cz.cestadomu.hospis.core.lib;

public class Transformation {
	public static final String AUTHENTICATION = "/transformation/authentication.xsl";
	public static final String AUTHENTICATION_RESULT = "/transformation/authenticationResult.xsl";
	public static final String GREETING = "/transformation/greeting.xsl";

	public static String xslt(String transformation) {
		return "xslt:" + transformation;
	}
}

package cz.cestadomu.hospis.core.lib;

public enum Transform {
	GET_VIEW_X_REQUEST_TRANSFORM("/transformation/getViewXRequest.xsl"), EMPLOYEES_RESPONSE_TRANSFORM(
			"/transformation/employeesResponse.xsl"), AUTHENTICATION(
					"/transformation/authentication.xsl"), AUTHENTICATION_RESULT(
							"/transformation/authenticationResult.xsl"), GREETING("/transformation/greeting.xsl");

	private String path;

	private Transform(String path) {
		this.path = path;
	}

	public String xslt() {
		return "xslt:" + this.path;
	}
}

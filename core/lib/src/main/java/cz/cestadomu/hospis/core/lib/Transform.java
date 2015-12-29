package cz.cestadomu.hospis.core.lib;

public enum Transform {
	GET_VIEW_X_REQUEST_TRANSFORM("/transform/getViewX/request.xsl"), //
	GET_VIEW_X_EMPLOYEES_RESPONSE_TRANSFORM("/transform/getViewX/employeesResponse.xsl"), //
	LOGIN_REQUEST("/transform/login/request.xsl"), //
	LOGIN_RESPONSE("/transform/login/response.xsl"), //
	GREETING("/transform/greeting.xsl");

	private String path;

	private Transform(String path) {
		this.path = path;
	}

	public String xslt() {
		return "xslt:" + this.path;
	}
}

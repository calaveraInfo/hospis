package cz.cestadomu.hospis.mock;

import java.io.InputStream;
import java.net.URL;

public enum Mock {
	CLIENT_LOGIN_REQUEST_MOCK("/mock/client/login/loginRequest.xml"), //
	CLIENT_LOGIN_RESPONSE_MOCK("/mock/client/login/loginResponse.xml"), //
	BACKEND_LOGIN_RESPONSE_MOCK("/mock/backend/login/loginResponse.xml"), //
	CLIENT_GET_VIEW_X_EMPLOYEE_REQUEST_MOCK("/mock/client/getViewX/employeesRequest"), //
	CLIENT_GET_VIEW_X_EMPLOYEE_RESPONSE_MOCK("/mock/client/getViewX/employeeResponse.xml"), //
	CLIENT_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK("/mock/client/getViewX/employeesResponse.xml"), //
	BACKEND_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK("/mock/backend/getViewX/employeesResponse.xml");

	private String path;

	private Mock(String path) {
		this.path = path;
	}

	public String mockClasspath() {
		return "classpath:" + this.path;
	}

	public URL resourceUrl() {
		return Mock.class.getResource(path);
	}

	public InputStream resourceStream() {
		return Mock.class.getResourceAsStream(this.path);
	}
}

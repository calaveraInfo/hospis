package cz.cestadomu.hospis.mock;

import java.io.InputStream;
import java.net.URL;

public enum Mock {
	AUTHENTICATION_RESULT("/authenticationResult.xml"), CREDENTIALS(
			"/credentials.xml"), LOGIN_RESPONSE("/login-response.xml"), EMPLOYEE(
					"/employee.xml"), EMPLOYEES("/employees.xml"), EMPLOYEES_RESPONSE(
							"/employees-response.xml");

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

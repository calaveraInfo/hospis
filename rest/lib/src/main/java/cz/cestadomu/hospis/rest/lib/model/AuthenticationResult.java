package cz.cestadomu.hospis.rest.lib.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"authenticated", "token"})
@XmlRootElement(name = "authenticationResult")
public class AuthenticationResult implements Serializable {

	protected boolean authenticated;
	protected String token;

	public AuthenticationResult() {}

	public AuthenticationResult(boolean authenticated, String token) {
		this.authenticated = authenticated;
		this.token = token;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

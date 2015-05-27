package cz.cestadomu.hospis.rest.web.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://www.cestadomu.cz/hospis/credentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credentials implements Serializable {

	@XmlElement(namespace = "http://www.cestadomu.cz/hospis/credentials")
	private String username;

	@XmlElement(namespace = "http://www.cestadomu.cz/hospis/credentials")
	private String password;

	public Credentials() {
	}

	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

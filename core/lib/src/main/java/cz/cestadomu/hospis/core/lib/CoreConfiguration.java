package cz.cestadomu.hospis.core.lib;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("core")
public class CoreConfiguration {

	@NotNull
	@Size(min = 1)
	private String testChannel;
	@NotNull
	@Size(min = 1)
	private String authenticationChannel;
	@NotNull
	@Size(min = 1)
	private String getViewXChannel;
	@NotNull
	@Size(min = 1)
	private String loginComponent;
	@NotNull
	@Size(min = 1)
	private String getViewXComponent;

	public String getTestChannel() {
		return testChannel;
	}

	public void setTestChannel(String testChannel) {
		this.testChannel = testChannel;
	}

	public String getAuthenticationChannel() {
		return authenticationChannel;
	}

	public void setAuthenticationChannel(String authenticationChannel) {
		this.authenticationChannel = authenticationChannel;
	}

	public String getLoginComponent() {
		return loginComponent;
	}

	public void setLoginComponent(String loginComponent) {
		this.loginComponent = loginComponent;
	}

	public String getGetViewXChannel() {
		return getViewXChannel;
	}

	public void setGetViewXChannel(String getViewXChannel) {
		this.getViewXChannel = getViewXChannel;
	}

	public String getGetViewXComponent() {
		return getViewXComponent;
	}

	public void setGetViewXComponent(String getViewXComponent) {
		this.getViewXComponent = getViewXComponent;
	}

}

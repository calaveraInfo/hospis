package cz.cestadomu.hospis.mock;

import static cz.cestadomu.hospis.mock.Mock.LOGIN_RESPONSE;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("login")
public class Login {
	private static final Logger LOG = LoggerFactory.getLogger(Login.class);

	public Login() {
		LOG.debug("Creating login mock.");
	}

	public String doLogin(String request) throws IOException {
		LOG.info("Recieved request to login mock component: {}", request);
		String response = IOUtils.toString(getClass().getResourceAsStream(LOGIN_RESPONSE));
		LOG.info("Returning mock response from login component: {}", response);
		return response;
	}

}

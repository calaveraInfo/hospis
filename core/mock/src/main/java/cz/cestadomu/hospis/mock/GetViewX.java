package cz.cestadomu.hospis.mock;

import static cz.cestadomu.hospis.mock.Mock.EMPLOYEES_RESPONSE;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("getViewX")
public class GetViewX {
	private static final Logger LOG = LoggerFactory.getLogger(GetViewX.class);

	public String doLogin(String request) throws IOException {
		LOG.info("Recieved request to get view x mock component: {}", request);
		String response = IOUtils.toString(getClass().getResourceAsStream(EMPLOYEES_RESPONSE));
		LOG.info("Returning mock response from get view x component: {}", response);
		return response;
	}

}

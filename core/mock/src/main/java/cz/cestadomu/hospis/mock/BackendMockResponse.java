package cz.cestadomu.hospis.mock;

import static cz.cestadomu.hospis.mock.Mock.BACKEND_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK;
import static cz.cestadomu.hospis.mock.Mock.BACKEND_LOGIN_RESPONSE_MOCK;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("backendMockResponse")
public class BackendMockResponse {
	private static final Logger LOG = LoggerFactory.getLogger(BackendMockResponse.class);

	public String mock(Mock mockResponseResource, String request) {
		LOG.info("Recieved request to backend mock component:\n{}", request);
		String response;
		try {
			response = IOUtils.toString(mockResponseResource.resourceUrl());
			LOG.info("Returning mock response from backend component:\n{}", response);
			return response;
		} catch (IOException e) {
			throw new RuntimeException("Unable to return mock response from backend component.", e);
		}
	}

	public String login(String request) {
		return mock(BACKEND_LOGIN_RESPONSE_MOCK, request);
	}

	public String getViewX(String request) {
		return mock(BACKEND_GET_VIEW_X_EMPLOYEES_RESPONSE_MOCK, request);
	}
}

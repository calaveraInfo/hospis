package cz.cestadomu.hospis.rest.lib.gateway;

import cz.cestadomu.hospis.model.AuthenticationResult;
import cz.cestadomu.hospis.model.Credentials;

public interface AuthenticationGateway {
	public AuthenticationResult authenticate(Credentials credentials);
}

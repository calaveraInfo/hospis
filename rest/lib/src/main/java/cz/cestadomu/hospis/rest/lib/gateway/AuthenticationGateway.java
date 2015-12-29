package cz.cestadomu.hospis.rest.lib.gateway;

import cz.cestadomu.hospis.rest.lib.model.AuthenticationResult;
import cz.cestadomu.hospis.rest.lib.model.Credentials;

public interface AuthenticationGateway {
	public AuthenticationResult authenticate(Credentials credentials);
}

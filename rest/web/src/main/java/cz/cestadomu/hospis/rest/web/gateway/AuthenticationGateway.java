package cz.cestadomu.hospis.rest.web.gateway;

import cz.cestadomu.hospis.rest.web.model.Credentials;

public interface AuthenticationGateway {
	public Boolean authenticate(Credentials credentials);
}

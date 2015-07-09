package cz.cestadomu.hospis.rest.web.gateway;

import cz.cestadomu.hospis.model.Credentials;

public interface AuthenticationGateway {
	public Boolean authenticate(Credentials credentials);
}

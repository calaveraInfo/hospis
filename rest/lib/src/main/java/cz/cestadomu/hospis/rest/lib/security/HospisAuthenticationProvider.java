package cz.cestadomu.hospis.rest.lib.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import cz.cestadomu.hospis.model.AuthenticationResult;
import cz.cestadomu.hospis.model.Credentials;
import cz.cestadomu.hospis.rest.lib.gateway.AuthenticationGateway;

@Component
public class HospisAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private AuthenticationGateway authenticationGateway;

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") final Class authentication) {
		if (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Authentication authenticate(final Authentication authentication)
			throws AuthenticationException {
		final Credentials credentials = new Credentials();
		credentials.setUsername(authentication.getPrincipal().toString());
		credentials.setPassword(authentication.getCredentials().toString());
		AuthenticationResult authenticationResult =
				this.authenticationGateway.authenticate(credentials);
		if (authenticationResult.isAuthenticated()) {
			return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authenticationResult.getToken(), Arrays.asList(new SimpleGrantedAuthority("USER")));
		}
		return authentication;
	}
}

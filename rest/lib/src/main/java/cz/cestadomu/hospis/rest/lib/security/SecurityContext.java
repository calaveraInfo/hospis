package cz.cestadomu.hospis.rest.lib.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("security")
public class SecurityContext {

	public String getIntuoToken() {
		return SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
	}
}

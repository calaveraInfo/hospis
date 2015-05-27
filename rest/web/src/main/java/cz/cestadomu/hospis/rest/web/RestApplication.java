package cz.cestadomu.hospis.rest.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import cz.cestadomu.hospis.rest.web.gateway.AuthenticationGateway;
import cz.cestadomu.hospis.rest.web.model.Credentials;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class RestApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestApplication.class);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Autowired
		private SecurityProperties security;

		@Autowired
		private AuthenticationGateway authenticationGateway;

		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(new AuthenticationProvider() {

				@Override
				public boolean supports(Class authentication) {
					if (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
					UsernamePasswordAuthenticationToken typedAuthentication = (UsernamePasswordAuthenticationToken) authentication;
					System.out.println(authenticationGateway.authenticate(new Credentials(authentication.getPrincipal().toString(), authentication
							.getCredentials().toString())));
					if (true) {
						return new Authentication() {

							@Override
							public String getName() {
								return authentication.getName();
							}

							@Override
							public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

							}

							@Override
							public boolean isAuthenticated() {
								return true;
							}

							@Override
							public Object getPrincipal() {
								return authentication.getPrincipal();
							}

							@Override
							public Object getDetails() {
								return authentication.getDetails();
							}

							@Override
							public Object getCredentials() {
								return authentication.getCredentials();
							}

							@Override
							public Collection<? extends GrantedAuthority> getAuthorities() {
								return authentication.getAuthorities();
							}
						};
					} else {
						return null;
					}
				}
			});
		}
	}
}

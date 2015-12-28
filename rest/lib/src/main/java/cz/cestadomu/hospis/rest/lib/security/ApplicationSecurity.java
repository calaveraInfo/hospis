package cz.cestadomu.hospis.rest.lib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private HospisAuthenticationProvider hospisAuthenticationProvider;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().regexMatchers("/private/.*").authenticated().and()
				.formLogin().loginPage("/login.html").usernameParameter("user")
				.passwordParameter("password").and().logout().logoutUrl("/logout.html");
	}

	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.hospisAuthenticationProvider)
				// Don't erase credentials because we store intuo token there
				.eraseCredentials(false);
	}
}

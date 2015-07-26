package cz.cestadomu.hospis.rest.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cz.cestadomu.hospis.rest.web.authentication.HospisAuthenticationProvider;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class RestApplication extends SpringBootServletInitializer {
	// TODO dynamicke urcovani portu mq, aby mohly testy probihat pri zapnutem
	// kontejneru.
	// TODO Odstranit vlastni implementaci marshalling message converteru, az
	// nebude potreba posilat binarni objekty.
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(RestApplication.class);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		public class HospisAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
			@Override
			public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
					throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");
				response.getWriter().print("{ \"user\": \"" + authentication.getName() + "\" }");
			}
		}

		@Autowired
		private HospisAuthenticationProvider hospisAuthenticationProvider;

		@Override
		protected void configure(final HttpSecurity http) throws Exception {
			http.csrf().disable().authorizeRequests().regexMatchers("/private/.*").authenticated().and().formLogin().loginPage("/login.html")
					.successHandler(new HospisAuthenticationSuccessHandler()).usernameParameter("user").passwordParameter("password").and().logout()
					.logoutUrl("/logout.html");
		}

		@Override
		public void configure(final AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(this.hospisAuthenticationProvider);
		}
	}
}

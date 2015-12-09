package cz.cestadomu.hospis.rest.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import cz.cestadomu.hospis.rest.lib.RestLib;

@SpringBootApplication
public class RestWeb extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(RestLib.class);
	}
}

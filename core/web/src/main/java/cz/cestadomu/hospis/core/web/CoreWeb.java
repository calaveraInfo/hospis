package cz.cestadomu.hospis.core.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import cz.cestadomu.hospis.core.lib.CoreLib;

@SpringBootApplication
public class CoreWeb extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(CoreLib.class);
	}

}

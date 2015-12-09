package cz.cestadomu.hospis.bundle;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import cz.cestadomu.hospis.core.lib.CoreLib;
import cz.cestadomu.hospis.mq.lib.MqLib;
import cz.cestadomu.hospis.rest.lib.RestLib;

@SpringBootApplication
public class Bundle extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(MqLib.class, CoreLib.class, RestLib.class);
	}
}

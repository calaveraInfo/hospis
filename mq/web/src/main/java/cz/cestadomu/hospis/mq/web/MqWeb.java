package cz.cestadomu.hospis.mq.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import cz.cestadomu.hospis.mq.lib.MqLib;

@SpringBootApplication
public class MqWeb extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MqLib.class);
	}
}

package cz.cestadomu.hospis.core.lib;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/core.properties")
public class CoreLib {
	public static final String MOCK_PROFILE = "mock";

	@Bean
	public ActiveMQComponent activemq() {
		final ActiveMQComponent component = new ActiveMQComponent();
		component.setBrokerURL("tcp://localhost:1983");
		return component;
	}
}

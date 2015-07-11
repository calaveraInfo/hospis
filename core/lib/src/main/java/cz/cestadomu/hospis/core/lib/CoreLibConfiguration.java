package cz.cestadomu.hospis.core.lib;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoreLibConfiguration {
	@Bean
	public ActiveMQComponent activemq() {
		final ActiveMQComponent component = new ActiveMQComponent();
		component.setBrokerURL("tcp://localhost:1983");
		return component;
	}
}

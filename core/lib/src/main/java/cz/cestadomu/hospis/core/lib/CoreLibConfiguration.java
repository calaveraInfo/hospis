package cz.cestadomu.hospis.core.lib;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CoreLibConfiguration {
	@Bean
	public ActiveMQComponent activemq() {
		ActiveMQComponent component = new ActiveMQComponent();
		component.setBrokerURL("tcp://localhost:1983");
		return component;
	}
}

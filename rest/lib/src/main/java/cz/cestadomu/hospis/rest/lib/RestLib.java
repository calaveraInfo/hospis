package cz.cestadomu.hospis.rest.lib;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class RestLib {
	// TODO dynamicke urcovani portu mq, aby mohly testy probihat pri zapnutem
	// kontejneru.
	// TODO Odstranit vlastni implementaci marshalling message converteru, az
	// nebude potreba posilat binarni objekty.

	// public IntegrationFlow
}

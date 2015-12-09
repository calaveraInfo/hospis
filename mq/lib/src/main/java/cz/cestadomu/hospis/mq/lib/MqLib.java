package cz.cestadomu.hospis.mq.lib;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:broker.xml")
public class MqLib {

}

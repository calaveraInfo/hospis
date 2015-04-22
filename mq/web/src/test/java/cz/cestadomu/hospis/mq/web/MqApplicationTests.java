package cz.cestadomu.hospis.mq.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cz.cestadomu.hospis.mq.web.MqApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MqApplication.class)
@WebAppConfiguration
public class MqApplicationTests {

	@Test
	public void contextLoads() {
	}

}

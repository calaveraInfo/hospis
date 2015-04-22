package cz.cestadomu.hospis.rest.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cz.cestadomu.hospis.rest.web.RestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestApplication.class, locations = "classpath:broker.xml")
@WebAppConfiguration
public class RestApplicationTests {

	@Test
	public void contextLoads() {
	}

}

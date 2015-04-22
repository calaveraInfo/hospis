package cz.cestadomu.hospis.core.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cz.cestadomu.hospis.core.web.CoreApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreApplication.class)
@WebAppConfiguration
public class CoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}

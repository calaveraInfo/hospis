package cz.cestadomu.hospis.rest.lib.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.cestadomu.hospis.model.Greeting;
import cz.cestadomu.hospis.rest.lib.gateway.TestGateway;
import cz.cestadomu.hospis.rest.lib.model.Test;

@RestController
public class TestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private TestGateway testGateway;

	@RequestMapping("/greeting")
	public Test greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting = new Greeting();
		greeting.setName(String.format(template, name));
		return new Test(counter.incrementAndGet(), testGateway.greeting(greeting).getName());
	}

}

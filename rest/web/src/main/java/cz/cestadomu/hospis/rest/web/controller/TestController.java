package cz.cestadomu.hospis.rest.web.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.cestadomu.hospis.rest.web.gateway.TestGateway;
import cz.cestadomu.hospis.rest.web.model.Test;

@RestController
public class TestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private TestGateway testGateway;

	@RequestMapping("/greeting")
	public Test greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Test(counter.incrementAndGet(), testGateway.greeting(String.format(template, name)));
	}

}

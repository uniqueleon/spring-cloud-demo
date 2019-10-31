package org.aztec.spring.client_3.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestService {
	
	@RequestMapping("/web/test/")
	public String sayHello() {
		return "{\"name\":\"good\",\"message\":\"hello\"}";
	}

}

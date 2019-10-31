package org.aztec.spring.client.demo2.web.controller;

import org.aztec.spring.client.demo2.entity.People;
import org.aztec.spring.client.demo2.feign.WebTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class TestFeignController {

	@Autowired
	private WebTestService service;

	@RequestMapping("/hello")
	public String getFeignHelloMsg() {
		return "Fetching msg from remote fiegn:" + service.getHelloString();
		//return "hello";
	}

	@RequestMapping("/person")
	public String showPerson(@RequestParam("personid") Long paramID) {
		People person = service.findByID(paramID);
		return person.toString();
	}
	


}

package org.aztec.spring.demo.config.client.web.controller;

import org.aztec.spring.demo.config.client.feig.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/test")
public class TestWebController {

	  @Value("${message.hello}")
	  String name = "World";

	  @RequestMapping("/")
	  public String home() {
	    return "Hello " + name ;
	  }
	  
	  @RequestMapping("/person")
	  public Person getPerson(@RequestParam("personID")Long persionID) {
		  return new Person(persionID,"");
	  }
}

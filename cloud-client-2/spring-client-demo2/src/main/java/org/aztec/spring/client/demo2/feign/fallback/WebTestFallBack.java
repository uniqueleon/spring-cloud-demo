package org.aztec.spring.client.demo2.feign.fallback;

import org.aztec.spring.client.demo2.feign.WebTestService;
import org.aztec.spring.demo.config.client.feig.Person;
import org.springframework.stereotype.Component;

@Component
public class WebTestFallBack implements WebTestService{

	public String getHelloString() {
		// TODO Auto-generated method stub
		return "SUCK!REMOTE IS DOWN";
	}

	public Person findByID(Long id) {
		return new Person(9999l,"ERROR");
	}

}

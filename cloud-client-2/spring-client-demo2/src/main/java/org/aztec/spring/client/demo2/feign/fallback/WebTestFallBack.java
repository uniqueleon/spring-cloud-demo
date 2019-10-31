package org.aztec.spring.client.demo2.feign.fallback;

import org.aztec.spring.client.demo2.entity.People;
import org.aztec.spring.client.demo2.feign.WebTestService;
import org.springframework.stereotype.Component;

@Component
public class WebTestFallBack implements WebTestService{

	public String getHelloString() {
		// TODO Auto-generated method stub
		return "SUCK!REMOTE IS DOWN";
	}

	public People findByID(Long id) {
		return new People(9999l,"ERROR");
	}

}

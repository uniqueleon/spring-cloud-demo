package org.aztec.spring.client.demo2.feign;

import org.aztec.spring.demo.config.client.feig.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="apptest")
public interface WebTestService {

	@RequestMapping(method = RequestMethod.GET,value="/web/test/")
	public String getHelloString();

	@RequestMapping(method = RequestMethod.POST,value="/web/test/person")
	public Person findByID(@RequestParam("personID")Long id);
}

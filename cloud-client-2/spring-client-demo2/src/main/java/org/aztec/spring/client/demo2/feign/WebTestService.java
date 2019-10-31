package org.aztec.spring.client.demo2.feign;

import org.aztec.spring.client.demo2.entity.People;
import org.aztec.spring.client.demo2.feign.fallback.WebTestFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="apptest",fallback = WebTestFallBack.class)
public interface WebTestService {

	@RequestMapping(method = RequestMethod.GET,value="/web/test/")
	public String getHelloString();

	@RequestMapping(method = RequestMethod.POST,value="/web/test/person")
	public People findByID(@RequestParam("personID")Long id);
}

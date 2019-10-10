package org.aztec.spring.client.demo2.web.controller;

import org.aztec.spring.client.demo2.dao.UserRepository;
import org.aztec.spring.client.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class TestJpaController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping("/user/{userid}")
	public String findUserById(@PathVariable("userid")Long userid) {
		User userData = repository.findById(userid).get();
		return userData.toString();
	}
}

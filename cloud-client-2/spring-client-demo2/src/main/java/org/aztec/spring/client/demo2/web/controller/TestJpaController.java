package org.aztec.spring.client.demo2.web.controller;

import java.util.List;
import java.util.Optional;

import org.aztec.spring.client.demo2.dao.UserRepository;
import org.aztec.spring.client.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class TestJpaController {
	
	@Autowired
	private UserRepository repository;

	@RequestMapping("/user/{userid}")
	public String findUserById(@PathVariable("userid")Long userid) {
		Optional<User> userData = repository.findById(userid);
		if(userData.isPresent()) {

			return userData.toString();
		}
		else {
			return "suck!no data of " + userid;
		}
	}
	

	@RequestMapping("/user/update")
	public String updateUser(@RequestParam("id") Long id,@RequestParam("name") String name) {
		Optional<User> userData = repository.findById(id);
		if(userData.isPresent()) {
			User newUser = userData.get();
			newUser.setName(name);
			return "update user success!id=" + id;
		}
		else {
			return "update user fail!id=" + id;
		}
		
	}
	

	@RequestMapping("/user/create")
	public String createUser(@RequestParam("id") Long id,@RequestParam("name") String name) {

		User newUser = new User();
		newUser.setName(name);
		newUser.setId(id);
		User userData = repository.saveAndFlush(newUser);
		return "created user success!id=" + userData.getId();
	}

	@RequestMapping("/user/findByName")
	public String findUserByName(@RequestParam("name") String name) {
		StringBuilder builder = new StringBuilder();
		List<User> retUsers = repository.findByName(name);
		for(User user : retUsers) {
			builder.append(user.toString());
		}
		return builder.toString();
	}
}

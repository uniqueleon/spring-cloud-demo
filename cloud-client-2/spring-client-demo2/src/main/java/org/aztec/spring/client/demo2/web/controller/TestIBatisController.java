package org.aztec.spring.client.demo2.web.controller;

import java.util.List;

import org.aztec.spring.client.demo2.entity.User;
import org.aztec.spring.client.demo2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ibatis")
public class TestIBatisController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("")
	public String findAllUser(){
		
		List<User> allUser = userMapper.findAll();
		return allUser.size() > 0 ? "ok" : "fail";
	}
}

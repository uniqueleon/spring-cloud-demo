package org.aztec.spring.client.demo2.web.controller;

import org.aztec.spring.client.demo2.conf.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config/")
public class TestConfigController {
	@Autowired
	RedisConfig redisConfig;

	@RequestMapping("redis")
	public String showRedisConfig() {
		return redisConfig.toString();
	}
}

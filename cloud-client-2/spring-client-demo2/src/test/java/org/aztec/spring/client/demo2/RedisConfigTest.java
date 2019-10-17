package org.aztec.spring.client.demo2;

import org.aztec.spring.client.demo2.conf.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisConfigTest {

	@Autowired
	private RedisConfig redisConfig;
	
	@Test
	public void testDisconf() {
		
	}
}

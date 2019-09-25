package org.aztec.spring.demo.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class Application {
	
	  @Value("${message.hello}")
	  String name = "World";

	  @RequestMapping("/")
	  public String home() {
	    return "Hello " + name;
	  }

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

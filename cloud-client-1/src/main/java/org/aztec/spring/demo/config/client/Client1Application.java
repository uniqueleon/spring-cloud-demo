package org.aztec.spring.demo.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@ComponentScan(basePackages = {"org.aztec.spring.demo.config.client.web"})
public class Client1Application {
	

	
	public static void main(String[] args) {
		SpringApplication.run(Client1Application.class, args);
	}
}

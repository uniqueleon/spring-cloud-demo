package org.aztec.spring.demo.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class EurekaClientApp {

	public static void main(String[] args) {

		SpringApplication.run(EurekaClientApp.class, args);
	}
}

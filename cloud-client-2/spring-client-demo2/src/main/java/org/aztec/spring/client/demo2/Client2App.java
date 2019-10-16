package org.aztec.spring.client.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
@ImportResource(locations = {"classpath:spring-disconf.xml"})
@ComponentScan(basePackages =  {"org.aztec.spring.client.demo2.web",
		"org.aztec.spring.client.demo2.feign.fallback",
		"org.aztec.spring.client.demo2.dao"})
public class Client2App 
{

	
    public static void main( String[] args )
    {
    	SpringApplication.run(Client2App.class, args);
    }
}

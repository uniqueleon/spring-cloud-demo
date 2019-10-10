package org.aztec.spring.client.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages =  {"org.aztec.spring.client.demo2.web","org.aztec.spring.client.demo2.feign.fallback"})
public class Client2App 
{

	
    public static void main( String[] args )
    {
    	SpringApplication.run(Client2App.class, args);
    }
}

package org.aztec.spring.client_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Server2Starter 
{
    public static void main( String[] args )
    {
		SpringApplication.run(Server2Starter.class, args);
    }
}

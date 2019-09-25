package org.aztec.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableEurekaServer
@RestController
public class ConfigServer {


  public static void main(String[] args) {
    SpringApplication.run(ConfigServer.class, args);
  }

}



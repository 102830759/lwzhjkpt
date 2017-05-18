package com.hdsx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LwzhjkptServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwzhjkptServerApplication.class, args);
	}
}

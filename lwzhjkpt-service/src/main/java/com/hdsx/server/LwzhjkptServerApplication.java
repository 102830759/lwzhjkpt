package com.hdsx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class LwzhjkptServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LwzhjkptServerApplication.class, args);
	}
}

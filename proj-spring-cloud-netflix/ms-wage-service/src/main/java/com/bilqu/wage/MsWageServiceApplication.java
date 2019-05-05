package com.bilqu.wage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsWageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWageServiceApplication.class, args);
	}

}

package com.lnsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//代表是eureka的客户端
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientCopyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientCopyApplication.class, args);
	}

}

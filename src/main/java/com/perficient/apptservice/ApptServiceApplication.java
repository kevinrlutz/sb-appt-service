package com.perficient.apptservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApptServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptServiceApplication.class, args);
	}

}

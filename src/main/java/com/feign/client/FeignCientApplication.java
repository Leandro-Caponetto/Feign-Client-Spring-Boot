package com.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignCientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignCientApplication.class, args);
	}

}

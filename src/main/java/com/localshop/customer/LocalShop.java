package com.localshop.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class LocalShop {

	public static void main(String[] args) {
		SpringApplication.run(LocalShop.class, args);
	}

}

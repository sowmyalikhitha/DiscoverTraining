package com.productdata2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Product2Application {

	public static void main(String[] args) {
		SpringApplication.run(Product2Application.class, args);
	}

}

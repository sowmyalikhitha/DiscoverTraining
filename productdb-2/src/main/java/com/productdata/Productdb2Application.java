package com.productdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Productdb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Productdb2Application.class, args);
	}

}

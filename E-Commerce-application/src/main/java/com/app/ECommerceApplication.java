package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.model.Customer;

@SpringBootApplication
public class ECommerceApplication {

	@Bean
	public Customer customer() {
		return new Customer();

	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}

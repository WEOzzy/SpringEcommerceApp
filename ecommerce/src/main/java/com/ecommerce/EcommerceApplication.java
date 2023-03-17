package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages =
							"com.ecommerce.controllers, " +
							"com.ecommerce.daos, " +
							"com.ecommerce.exceptions, " +
							"com.ecommerce.models, " +
							"com.ecommerce.services, " +
							"com.ecommerce.advice, "	+
							"com.ecommerce.annotations"
					)

public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}

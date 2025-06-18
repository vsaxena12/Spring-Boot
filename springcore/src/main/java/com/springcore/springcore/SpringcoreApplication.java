package com.springcore.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is equal to
 * @ComponentScan
 * @Configuration
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class SpringcoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}
}

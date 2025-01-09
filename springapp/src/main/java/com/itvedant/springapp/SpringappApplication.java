package com.itvedant.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		System.out.println("Application Started....");
		SpringApplication.run(SpringappApplication.class, args);
		
		System.out.println("Application finished....");
	}

}

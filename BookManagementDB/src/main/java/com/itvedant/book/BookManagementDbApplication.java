package com.itvedant.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class BookManagementDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementDbApplication.class, args);
	}

}

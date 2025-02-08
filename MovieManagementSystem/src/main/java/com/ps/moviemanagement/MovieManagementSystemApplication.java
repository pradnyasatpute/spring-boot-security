package com.ps.moviemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorage.class})
public class MovieManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieManagementSystemApplication.class, args);
	}

}

package com.ps.tourpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class TourPackageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourPackageApplication.class, args);
	}

}

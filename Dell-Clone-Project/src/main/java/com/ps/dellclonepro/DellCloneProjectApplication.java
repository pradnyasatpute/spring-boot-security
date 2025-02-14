package com.ps.dellclonepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class DellCloneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DellCloneProjectApplication.class, args);
	}

}

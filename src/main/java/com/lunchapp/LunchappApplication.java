package com.lunchapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LunchappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunchappApplication.class, args);
	}

}

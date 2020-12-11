package com.assignment.mapboxpoisearchproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MapboxpoisearchprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapboxpoisearchprojectApplication.class, args);
	}
	
	//return restTemplate bean
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}

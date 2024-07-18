package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BootRestProj11RestApiConsumerAppApplication {

	@Bean
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(BootRestProj11RestApiConsumerAppApplication.class, args);
	}

}

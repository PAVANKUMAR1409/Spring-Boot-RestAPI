package com.pk.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorRunner_GettingJSON_Data implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		// service url
		String serviceUrl = "http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/report";

		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);

		// display recieved details from response
		System.out.println("Response Body (output) :: " + response.getBody());
		System.out.println("Response Headers :: " + response.getHeaders().toString());
		System.out.println("Response Status Code Value :: " + response.getStatusCode());
	}
}

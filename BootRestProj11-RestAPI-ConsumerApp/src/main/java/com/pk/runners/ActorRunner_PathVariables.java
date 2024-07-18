package com.pk.runners;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ActorRunner_PathVariables implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		// defin service url
		String url="http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/wish/{id}/{name}";
		
		//Generate HttpRequest with GET mode to consume the web service(API)
		//ResponseEntity<String> response = template.getForEntity(url, String.class, 1001,"pavan");  //order must be followed
		ResponseEntity<String> response = template.getForEntity(url, String.class,Map.of("name","pavan","id",1004));
		
		
		//display the recieved details from response
		System.out.println("Response Body (output) :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCodeValue());
		System.out.println("Response Header :: "+response.getHeaders().toString());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		
	}

}

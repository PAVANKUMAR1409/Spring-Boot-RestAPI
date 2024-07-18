package com.pk.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.model.Actor;

@Component
public class ActorRunner_GettingJSON_Data implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		// service url
		//String serviceUrl = "http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/report";
		String serviceUrl = "http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/reportAll";

		//only one actor object
	//	ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null  ,String.class);//null because there is no body for get request
		
		//for list of actor objects
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null  ,String.class);																																			
		
		
		// display recieved details from response
		System.out.println("Response Body (output) :: " + response.getBody());
		System.out.println("Response Headers :: " + response.getHeaders().toString());
		System.out.println("Response Status Code Value :: " + response.getStatusCode());
		
		System.out.println("================JSON TO STRING====================");
		String json_content = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list = mapper.readValue(json_content, new TypeReference<List<Actor>>() {});
		
		list.forEach(System.out::println);
	}	
}

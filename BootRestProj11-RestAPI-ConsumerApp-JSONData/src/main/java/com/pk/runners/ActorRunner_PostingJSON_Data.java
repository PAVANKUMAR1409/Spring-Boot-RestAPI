package com.pk.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorRunner_PostingJSON_Data implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		//define Service url
		String serviceUrl="http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/register";
		
		//prepare JSON Data (Request Body)
		String json_body = "{\"id\":100,\"name\":\"pavan\",\"addrs\":\"hyderabad\",\"actingType\":\"comedy\"}";
		
		//prepare headers
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//Prepare Http request HttpEntity Object having head and body
		HttpEntity<String> request= new HttpEntity<String>(json_body,headers);
		
		//make http request call in post mode
		ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);   //url,request,output type
		
		//display recieved details from response
		System.out.println("Response Body (output) :: "+response.getBody());
		System.out.println("Response Headers :: "+response.getHeaders().toString());
		System.out.println("Response Status Code Value :: "+response.getStatusCode());
	}

}

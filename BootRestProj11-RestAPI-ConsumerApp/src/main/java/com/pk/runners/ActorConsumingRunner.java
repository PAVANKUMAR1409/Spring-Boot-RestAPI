package com.pk.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorConsumingRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*//define servie ur;
		String baseUrl= "http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/wish";
		
		//genearate HTTP request with GET mode to consume web service
		ResponseEntity<String> reponse = template.getForEntity(baseUrl, String.class);
		
		//display details from response
		System.out.println("Response Body (o/p) :: "+reponse.getBody());   // we get response output
		System.out.println("Response Status Code Value  :: "+reponse.getStatusCode());   //200 OK
		System.out.println("Response Status Code Name  :: "+reponse.getStatusCode().value()); //200
		*/
		
		//define servie ur;
				String baseUrl= "http://localhost:8082/BootRestProj11-RestAPI-ProviderApp/actor-api/wish";
				
				//genearate HTTP request with GET mode to consume web service
				String reponse = template.getForObject(baseUrl, String.class);
				
				//display details from response
				System.out.println("Response Body (o/p) :: "+reponse); // we get only response body
		
	}

}

package com.pk.rest;

import java.time.LocalTime;
import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class WishMessageOperationsController {

	/*@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage(){
		System.out.println("WishMessageOperationsController.showWishMessage()");
		// LocalTime class object
		LocalTime lt = LocalTime.now();
		//get hour
		int hour= lt.getHour();
		String msg="";
		if(hour<12)
			msg="GoodMorning";
		else if(hour<16)
			msg="GoodAfternoon";
		else if(hour<20)
			msg="GoodEvening";
		else
			msg="GoodNight";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}*/
	@GetMapping("/wish")
	public String showWishMessage(){
		System.out.println("WishMessageOperationsController.showWishMessage()");
		// LocalTime class object
		LocalTime lt = LocalTime.now();
		//get hour
		int hour= lt.getHour();
		String msg="";
		if(hour<12)
			msg="GoodMorning";
		else if(hour<16)
			msg="GoodAfternoon";
		else if(hour<20)
			msg="GoodEvening";
		else
			msg="GoodNight";
		
		return msg;
	}
}

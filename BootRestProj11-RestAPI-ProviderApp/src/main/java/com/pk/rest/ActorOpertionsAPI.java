package com.pk.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOpertionsAPI {

	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage(){
		return new ResponseEntity<String>("Good Night",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage1(@PathVariable Integer id, @PathVariable String name){
		return new ResponseEntity<String>("Good Morning"+id+"==="+name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor Data"+actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Actor> showActorData(){
		Actor actor= new Actor(101,"Pavan","Hyd","Hero");
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/reportAll")
	public ResponseEntity<List<Actor>> showActorDataAll(){
		Actor actor1= new Actor(101,"Pavan","Hyd","Hero");
		Actor actor2= new Actor(102,"Surya","Hyd","Villian");
		Actor actor3= new Actor(103,"Radha","Hyd","Comedian");
		
		List<Actor> list= List.of(actor1, actor2,actor3);
		return new ResponseEntity<List<Actor>>(list,HttpStatus.OK);
	}
}

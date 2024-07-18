package com.pk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.model.Student;

@RestController
@RequestMapping("/student-api")
public class StudentOperationController {

	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student stu){
			
			System.out.println("Model Class Atrributes :: "+stu);
			return new ResponseEntity<String>(stu.toString(),HttpStatus.OK);
	}
}

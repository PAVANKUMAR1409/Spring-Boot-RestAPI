package com.pk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerOperationsController {
	
	/*@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport(@PathVariable Integer no, @PathVariable String name){
		System.out.println(no+"  ::  "+name);
		return new ResponseEntity<String>(no+" :: "+name,HttpStatus.OK);
	}*/
	
	/*
	 * http://localhost:8082/BootRestProj08-PathVariables/report/101/pavan ====>Success (o/p - 101 :: pavan)
	 * http://localhost:8082/BootRestProj08-PathVariables/report/pavan/101    ====>400 Bad Request
	 * http://localhost:8082/BootRestProj08-PathVariables/report/101  =====>404 Not Found
	 * http://localhost:8082/BootRestProj08-PathVariables/report/pavan =====> 404 Not Found
	 * http://localhost:8082/BootRestProj08-PathVariables/report/101/pavan/hyd =====> 404 Not Found
	 */
	/*@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport(@PathVariable Integer no, @PathVariable String name){
		System.out.println(no+"  ::  "+name);
		return new ResponseEntity<String>(no+" :: "+name,HttpStatus.OK);
	}*/
	
	/*
	 *  http://localhost:8082/BootRestProj08-PathVariables/report/pavan/101====>Success (o/p-- pavan :: 101)
	 */
	/*@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport(@PathVariable String no, @PathVariable String name){
		System.out.println(no+"  ::  "+name);
		return new ResponseEntity<String>(no+" :: "+name,HttpStatus.OK);
	}*/
	
	/*
	 * http://localhost:8082/BootRestProj08-PathVariables/report/101 ===> 404 Not Found
	 * 	 (we expect 101 :: null but we get 404 error becoz bynamic path variables must be given)
	 * http://localhost:8082/BootRestProj08-PathVariables/report  ===> 404 Not Found (Expected null :: null)
	 * 
	 */
	/*@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println(no+"  ::  "+name);
		return new ResponseEntity<String>(no+" :: "+name,HttpStatus.OK);
	}*/
	
	
	
	
	/*
	 * If multiple methods are having similar request paths having same no.of levels then the request 
	 * 								that is having more static level matchings will get priority
	 * 1. http://localhost:8082/BootRestProj08-PathVariables/report/no/name  --o/p  : showReport1==>null :: null
	 * 2. http://localhost:8082/BootRestProj08-PathVariables/report/no/pavan -- o/p : showReport2==>null :: pavan
	 * 3. http://localhost:8082/BootRestProj08-PathVariables/report/101/name --o/p : showReport3==>101 :: null
	 * 4. http://localhost:8082/BootRestProj08-PathVariables/report/101/pavan --o/p : showReport3==>101 :: pavan
	 * 
	 */
	/*@GetMapping("/report/no/name")
	public ResponseEntity<String> showReport1(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport1()");
		
		return new ResponseEntity<String>("showReport1==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/no/{name}")
	public ResponseEntity<String> showReport2(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport2()");
		
		return new ResponseEntity<String>("showReport2==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/{no}/name")
	public ResponseEntity<String> showReport3(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport3()");
		
		return new ResponseEntity<String>("showReport3==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport4(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport4()");
		
		return new ResponseEntity<String>("showReport4==>"+no+" :: "+name,HttpStatus.OK);
	}*/
	
	/*
	 * 1.http://localhost:8082/BootRestProj08-PathVariables/report/101/pavan -- o/p :: showReport1==>null :: null
	 * 2.http://localhost:8082/BootRestProj08-PathVariables/report/101/surya -- o/p :: showReport2==>101 :: surya
	 */
	/*@GetMapping("/report/101/pavan")
	public ResponseEntity<String> showReport1(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport1()");
		
		return new ResponseEntity<String>("showReport1==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> showReport2(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport2()");
		
		return new ResponseEntity<String>("showReport2==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	// if two methods  are having same request path with same no.of levels 
	//    then there is possibility of getting IllegalStateException during application startup
	@GetMapping("/report/101/pavan")    
	public ResponseEntity<String> showReport3(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport3()");
		
		return new ResponseEntity<String>("showReport3==>"+no+" :: "+name,HttpStatus.OK);
	}*/
	
	/*
	 * 1. http://localhost:8082/BootRestProj08-PathVariables/report/101/pavan -- o/p :: showReport==>101 :: pavan
	 * 2. http://localhost:8082/BootRestProj08-PathVariables/report/101  --  o/p :: showReport==>101 :: null
	 * 3. http://localhost:8082/BootRestProj08-PathVariables/report/pavan  --  o/p :: showReport==>pavan :: null
	 * 
	 */
	@GetMapping(value= {"/report/{no}/{name}", "/report/{no}"})    
	public ResponseEntity<String> showReport(@PathVariable(required = false) String no, @PathVariable(required = false) String name){
		System.out.println("PlayerOperationsController.showReport()");
		
		return new ResponseEntity<String>("showReport==>"+no+" :: "+name,HttpStatus.OK);
	}
	
	
}

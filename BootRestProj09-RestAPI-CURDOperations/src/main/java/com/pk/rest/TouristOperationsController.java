package com.pk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.entity.Tourist;
import com.pk.service.ITouristService;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {

	@Autowired
	private ITouristService touristService;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
	{
		try {
			String msg = touristService.registerTourist(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);  //201 created
		}catch(Exception e) {
			return new ResponseEntity<String>("Problem in tourist enrollment",HttpStatus.INTERNAL_SERVER_ERROR); // error 500
		}//catch
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayAllTourists(){
		try {
			List<Tourist> list = touristService.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);  //200 
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem found in fecthing tourists",HttpStatus.INTERNAL_SERVER_ERROR);  // error 500
		}
		
	}
	
	@GetMapping("/findById/{tid}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer tid){
		
		try {
			Tourist tourist = touristService.fetchTouristById(tid);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
		}//try-catch
	}// method
	
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		try {
			String msg = touristService.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}//try-catch
	}//method
	
	@PatchMapping("/p-modify/{tid}/{hikePercentage}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer tid,@PathVariable Double hikePercentage){
		try {
			//use service
			String msg = touristService.updateTouristBudgetById(tid, hikePercentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}//try-catch
	}//method
	
	@DeleteMapping("/delete/{tid}")
	public ResponseEntity<String> removeTouristById(@PathVariable Integer tid){
		try {
			String msg = touristService.removeTouristById(tid);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.pk.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.model.Company;
import com.pk.model.Customer;

@RestController
@RequestMapping ("/customer-api")
public class CustomerOperationsController {
	
	@GetMapping("/report")
	public ResponseEntity<Customer> showReport(){
		Customer cust = new Customer();
		cust.setCno(1001);cust.setCname("Pavan");cust.setBillAmt(7800.0f);cust.setCadd("Hyderabad");
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/report1")
	public ResponseEntity<Customer>  showReport1() {
		Customer cust= new Customer();
		cust.setCno(1002);cust.setCname("Pavan"); cust.setBillAmt(8900.00f); cust.setCadd("Hyderabad");
		cust.setFavColors(new String[] {"red","blue","green","white"});
		cust.setFriends(List.of("surya","chani","santhu","ramesh"));
		cust.setPhoneNos(Set.of(999999l,888888l,777777l,666666666l));
		cust.setIdDetails(Map.of("aadhar",678905,"panCard","ABIF123","Voter",123456));
		cust.setCompany(new Company(100, "HCL", "HiTech", 1000));
		
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	
	@GetMapping("/report2")
	public ResponseEntity<List<Customer>>  showReport2() {
		Customer cust1= new Customer(1001, "Pavan", "Hyd", 5600.0f);
		Customer cust2= new Customer(1002, "Soumya", "KNR", 9600.0f);
		Customer cust3= new Customer(1001, "Surya", "PDPL", 3600.0f);
		
		return new ResponseEntity<List<Customer>>(List.of(cust1,cust2,cust3),HttpStatus.OK);
		
	}
	
	@GetMapping("/report3")
	public Customer showReport3(){
		Customer cust = new Customer();
		cust.setCno(1001);cust.setCname("Pavan");cust.setBillAmt(7800.0f);cust.setCadd("Hyderabad");
		return cust;
	}
	
	
	
	
	
	
	
	
}

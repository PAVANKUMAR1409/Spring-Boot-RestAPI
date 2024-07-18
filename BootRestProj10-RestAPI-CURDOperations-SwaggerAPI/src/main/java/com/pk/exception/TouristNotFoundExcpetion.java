package com.pk.exception;

public class TouristNotFoundExcpetion extends Exception {

	private String msg ;

	public TouristNotFoundExcpetion(String msg) {
		this.msg = msg;
	}
	
	public TouristNotFoundExcpetion() {
		
	}
	
}

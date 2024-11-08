package com.example.pms.exception;

public class InvalidDateException extends RuntimeException {
	private final String message;



	public InvalidDateException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	

}

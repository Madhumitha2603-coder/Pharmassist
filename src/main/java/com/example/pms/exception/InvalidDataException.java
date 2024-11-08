package com.example.pms.exception;

public class InvalidDataException extends RuntimeException {
	private final String message;



	public InvalidDataException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	

}

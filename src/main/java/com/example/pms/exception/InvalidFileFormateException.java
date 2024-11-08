package com.example.pms.exception;

public class InvalidFileFormateException extends RuntimeException {
	private final String message;



	public InvalidFileFormateException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	

}

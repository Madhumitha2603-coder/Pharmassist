package com.example.pms.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pms.exception.InvalidDateFormatException;
import com.example.pms.exception.InvalidFileFormateException;
import com.example.pms.exception.NoAdminFoundException;
import com.example.pms.utility.AppResponseBuilder;
import com.example.pms.utility.ErrorStructure;

@RestControllerAdvice
public class MedicineExceptionHandler {
	private final AppResponseBuilder responseBuilder;

	public MedicineExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	@ExceptionHandler(NoAdminFoundException.class)
	public ResponseEntity<ErrorStructure> handleDateFormat(InvalidDateFormatException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),"Data is not Found");
	}
	@ExceptionHandler(InvalidFileFormateException.class)
	public ResponseEntity<ErrorStructure> handleFileFormat(InvalidDateFormatException ex) {
		
		return responseBuilder.error(HttpStatus.NOT_ACCEPTABLE,ex.getMessage(),"File Format is invalid");
	}

}

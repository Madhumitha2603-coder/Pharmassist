package com.example.pms.exceptionhandler;


	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;

	import com.example.pms.exception.NoPatientsFoundException;
	import com.example.pms.exception.PatientNotFoundByIdException;
	import com.example.pms.utility.AppResponseBuilder;
	import com.example.pms.utility.ErrorStructure;

	@RestControllerAdvice
	public class PatientExceptionHandler {

		private final AppResponseBuilder responseBuilder;

		public PatientExceptionHandler(AppResponseBuilder responseBuilder) {
			super();
			this.responseBuilder = responseBuilder;
		}
		
		@ExceptionHandler(PatientNotFoundByIdException.class)
		public ResponseEntity<ErrorStructure> handlePatientFoundNotById(PatientNotFoundByIdException ex) {
			
			return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"No patients found based on the id");
		}
		
		@ExceptionHandler(NoPatientsFoundException.class)
		public ResponseEntity<ErrorStructure> handleNoPatientsFound(NoPatientsFoundException ex) {
			
			return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"No patient is associated with the pharmacy Id");
		}
	

}

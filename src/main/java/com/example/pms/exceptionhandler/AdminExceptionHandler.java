package com.example.pms.exceptionhandler;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;

	import com.example.pms.exception.AdminNotFoundByIdException;
	import com.example.pms.exception.NoAdminFoundException;
	import com.example.pms.utility.AppResponseBuilder;
	import com.example.pms.utility.ErrorStructure;

	@RestControllerAdvice
	public class AdminExceptionHandler {
		
		private final AppResponseBuilder responseBuilder;

		public AdminExceptionHandler(AppResponseBuilder responseBuilder) {
			super();
			this.responseBuilder = responseBuilder;
		}
		
		@ExceptionHandler(NoAdminFoundException.class)
		public ResponseEntity<ErrorStructure> handleNoAdminsFound(NoAdminFoundException ex) {
			
			return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"No admins found based on the criteria");
		}
		
		@ExceptionHandler(AdminNotFoundByIdException.class)
		public ResponseEntity<ErrorStructure> handleAdminNotFoundById(AdminNotFoundByIdException ex) {
			
			return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"Admin is not found by Id");
		}
		@ExceptionHandler(UsernameNotFoundException.class)
		public ResponseEntity<ErrorStructure> handleUsernameNotFoundById(UsernameNotFoundException ex) {

			return responseBuilder.error(HttpStatus.NOT_FOUND,ex.getMessage(),"Username is not found by id ");
		}


}

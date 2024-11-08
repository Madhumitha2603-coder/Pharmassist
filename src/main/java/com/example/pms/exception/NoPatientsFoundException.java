package com.example.pms.exception;

	public class NoPatientsFoundException  extends RuntimeException {
		 
		private final String message;

		public NoPatientsFoundException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
		

}

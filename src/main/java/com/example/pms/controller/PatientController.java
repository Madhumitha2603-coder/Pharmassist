package com.example.pms.controller;


	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.pms.requestdtos.PatientRequest;
	import com.example.pms.responsedtos.PatientResponse;
	import com.example.pms.service.PatientService;
	import com.example.pms.utility.AppResponseBuilder;
	import com.example.pms.utility.ResponseStructure;

	import jakarta.validation.Valid;

	@RestController
	public class PatientController {
		
		private final PatientService patientService;
		private final AppResponseBuilder responseBuilder;
		
		public PatientController(PatientService patientService, AppResponseBuilder responseBuilder) {
			super();
			this.patientService = patientService;
			this.responseBuilder = responseBuilder;
		}
		
		@PostMapping("/pharmacies/{pharmacyId}/patients")
		public ResponseEntity<ResponseStructure<PatientResponse>> addPatient(@RequestBody @Valid PatientRequest patientRequest, @PathVariable String pharmacyId) {
			 PatientResponse response = patientService.addPatient(patientRequest,pharmacyId);
			 return responseBuilder.success(HttpStatus.CREATED,"Patient registered",response);
		}	
		
		

}

package com.example.pms.controller;


	import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.multipart.MultipartFile;

import com.example.pms.responsedtos.MedicineResponse;
import com.example.pms.service.MedicineService;
	import com.example.pms.utility.AppResponseBuilder;
import com.example.pms.utility.ResponseStructure;
import com.example.pms.utility.SimpleResponseStructure;

	@RestController
	public class MedicineController {
		
		private final AppResponseBuilder responseBuilder;
		private final MedicineService medicineService;

		public MedicineController(AppResponseBuilder responseBuilder, MedicineService medicineService) {
			super();
			this.responseBuilder = responseBuilder;
			this.medicineService = medicineService;
		}
		@PostMapping("/pharmacies/{pharmacyId}/medicines")
		public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam("medicine_info") MultipartFile file,@PathVariable String pharmacyId) {
			
			String message = medicineService.uploadMedicines(file, pharmacyId);
			return responseBuilder.success(HttpStatus.CREATED, message);
			
		}
		@GetMapping("/medicines")
		public ResponseEntity<ResponseStructure<List<MedicineResponse>>> findMedicineByNameOrIngredients(
				@RequestParam String text){
			
			List<MedicineResponse> responses = medicineService.findMedicineByNameOrIngredients(text);
			return responseBuilder.success(HttpStatus.FOUND, "Medicine found successfully",responses);
			
		}



}

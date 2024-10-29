package com.example.pms.controller;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.example.pms.request.AdminRequest;
import com.example.pms.response.AdminResponse;
import com.example.pms.service.AdminService;
import com.example.pms.utility.AppResponseBuilder;
import com.example.pms.utility.ResponseStructure;

import jakarta.validation.Valid;

	@RestController

public class AdminController {
		
		private final AdminService adminService;
		private final AppResponseBuilder responseBuilder;
		
		public AdminController(AdminService adminService, AppResponseBuilder responseBuilder) {
			super();
			this.adminService = adminService;
			this.responseBuilder = responseBuilder;
		}
		
		@PostMapping("/admins")
		public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody @Valid AdminRequest adminRequest) {
			System.out.println("hello");
			AdminResponse response =  adminService.saveAdmin(adminRequest);
			return responseBuilder.success(HttpStatus.CREATED, "Admin Created",response);
			
		}
		
		
		
		

	

}

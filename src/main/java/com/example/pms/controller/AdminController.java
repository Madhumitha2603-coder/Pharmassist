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

	import com.example.pms.requestdtos.AdminRequest;
	import com.example.pms.responsedtos.AdminResponse;
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
		
		@PostMapping("/register")
		public ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest) {
		
			AdminResponse response =  adminService.addAdmin(adminRequest);
			return responseBuilder.success(HttpStatus.CREATED, "Admin Created",response);
		}
		

		@GetMapping("/findadmins/{adminId}")
		public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(@PathVariable String adminId) {
			
			AdminResponse response = adminService.findAdmin(adminId);
			return responseBuilder.success(HttpStatus.FOUND,"Admin Found", response);
		}
		@GetMapping("/findalladmins")
		public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins() {
			
			List<AdminResponse> responses = adminService.findAllAdmins();
			return responseBuilder.success(HttpStatus.FOUND,"Admins Found", responses);
		}
		@PutMapping("/updateadmins/{adminId}")
		public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String adminId) {
			
			AdminResponse response = adminService.updateAdmin(adminRequest, adminId);
			return responseBuilder.success(HttpStatus.OK,"Admin updated", response);
		}

}

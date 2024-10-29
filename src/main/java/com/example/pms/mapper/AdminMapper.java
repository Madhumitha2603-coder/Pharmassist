package com.example.pms.mapper;

import org.springframework.stereotype.Component;

import com.example.pms.entity.Admin;
import com.example.pms.request.AdminRequest;
import com.example.pms.response.AdminResponse;

@Component
	public class AdminMapper {
		
		public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
			
			admin.setAdminEmail(adminRequest.getAdminEmail());
			admin.setAdminPassword(adminRequest.getAdminPassword());
			admin.setPhoneNumber(adminRequest.getPhoneNumber());
			
			return admin;
		}
		
		public AdminResponse mapToAdminResponse( Admin admin) {
			
			AdminResponse response = new AdminResponse();
			response.setAdminId(admin.getAdminId());
			response.setAdminEmail(admin.getAdminEmail());
			
			return response;
		}

	


}

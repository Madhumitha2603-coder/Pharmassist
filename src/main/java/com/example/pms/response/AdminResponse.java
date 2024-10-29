package com.example.pms.response;

import org.springframework.stereotype.Component;

@Component
	public class AdminResponse {
		private String adminId;
		private String adminEmail;
		
		public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
		public String getAdminEmail() {
			return adminEmail;
		}
		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}
		
		

	


}

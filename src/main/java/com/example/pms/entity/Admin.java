package com.example.pms.entity;

import com.example.pms.config.GenerateCustomerId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

	@Entity
	public class Admin {
		@Id
		@GenerateCustomerId
		private String adminId;
		private String adminEmail;
		private String phoneNumber;
		private String adminPassword;
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
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAdminPassword() {
			return adminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}

	}



package com.example.pms.request;


import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Component
public class AdminRequest {

	
//	@NotNull(message = "Email cannot be null")
//	@NotBlank(message = "Email cannot be blank")
//	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$\r\n", message = "Invalid emailId")
	private String adminEmail;
	
////	@NotNull(message = "Phonenumber cannot be null")
//	@NotBlank(message = "Phonenumber cannot be blank")
//	@Pattern(regexp = "^(\\+91|0)?[6-9]\\d{9}$\r\n", message = "Enter valid phonenumber")
	private String phoneNumber;
//	
//	@NotNull(message = "Password cannot be null")
//	@NotBlank(message = "Password cannot be blank")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n",
//	message = "Password must contain atleast 1 uppercase letter, lowercase letter, number and a special character")
	private String adminPassword;


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




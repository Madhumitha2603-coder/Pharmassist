package com.example.pms.entity;


	import java.time.LocalDate;

	import com.example.pms.config.GenerateCustomerId;
	import com.example.pms.enums.Gender;

	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.ManyToOne;

	@Entity
	public class Patient {
		
		@Id
		@GenerateCustomerId
		private String patientId;
		private String patientName;
		private String patientEmail;
		private String patientPhoneNumber;
		private Gender patientGender;
		private LocalDate patientDateOfBirth;
		
		@ManyToOne
		private Pharmacy pharmacy;
		
		public Pharmacy getPharmacy() {
			return pharmacy;
		}
		public void setPharmacy(Pharmacy pharmacy) {
			this.pharmacy = pharmacy;
		}
		public String getPatientId() {
			return patientId;
		}
		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getPatientEmail() {
			return patientEmail;
		}
		public void setPatientEmail(String patientEmail) {
			this.patientEmail = patientEmail;
		}
		public String getPatientPhoneNumber() {
			return patientPhoneNumber;
		}
		public void setPatientPhoneNumber(String patientPhoneNumber) {
			this.patientPhoneNumber = patientPhoneNumber;
		}
		public Gender getPatientGender() {
			return patientGender;
		}
		public void setPatientGender(Gender patientGender) {
			this.patientGender = patientGender;
		}
		public LocalDate getPatientDateOfBirth() {
			return patientDateOfBirth;
		}
		public void setPatientDateOfBirth(LocalDate patientDateOfBirth) {
			this.patientDateOfBirth = patientDateOfBirth;
		}
		


}

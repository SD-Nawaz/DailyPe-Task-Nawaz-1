package com.example.model;

	import java.util.UUID;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.NotEmpty;
	import jakarta.validation.constraints.Pattern;

	@Entity
	@Table(name = "app_user")
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID id;

	    private UUID managerId;

	    @NotEmpty(message = "Full name should not be empty")
	    private String fullName;

	    @Pattern(regexp = "^(\\+91|0)?[0-9]{10}$", message = "Mobile number must be 10 digits and start with +91 or 0")
	    private String mobileNumber;

	    @Pattern(regexp = "^[A-Za-z0-9]{10}$", message = "PAN number must be a valid 10 digit alphanumeric value")
	    private String panNumber;

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public UUID getManagerId() {
			return managerId;
		}

		public void setManagerId(UUID managerId) {
			this.managerId = managerId;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getPanNumber() {
			return panNumber;
		}

		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
		}

		

	    
	}


	



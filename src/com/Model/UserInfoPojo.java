package com.Model;

import java.sql.Date;

public class UserInfoPojo {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int contactNo;
	private String email;
	private String organization;

	public UserInfoPojo(String firstName, String lastName, Date dateOfBirth,
			int contactNo, String email, String organization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactNo = contactNo;
		this.email = email;
		this.organization = organization;
	}

	public int getContactNo() {
		return contactNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getOrganization() {
		return organization;
	}
}

package com.Model;

public class FriendInfoPojo {
	private int id;
	private String firstName;
	private String lastName;

	public FriendInfoPojo(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}
}

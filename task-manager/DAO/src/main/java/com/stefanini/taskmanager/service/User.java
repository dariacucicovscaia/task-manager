package com.stefanini.taskmanager.service;

import java.util.UUID;

public class User {
	private String uuid;
	private String firstName;
	private String lastName;
	private String userName;

	public User() {

	}

	public User(String uuid, String firstName, String lastName, String userName) {
		super();
		setUuid(uuid);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);

	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + "]";
	}

}

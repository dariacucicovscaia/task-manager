package com.stefanini.taskmanager.domain;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;

	public User() {

	}

	public User(int id, String firstName, String lastName, String userName) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public User(String firstName, String lastName, String userName) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ "]";
	}

}

package com.stefanini.taskmanager.service;

import java.sql.SQLException;
import java.util.UUID;

public class UserFactory {
	public User createUser(  String firstName, String lastName, String userName) throws SQLException {
		User u = new User(UUID.randomUUID(), firstName, lastName, userName);
		return u;
	}
}

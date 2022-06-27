package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.User;

public interface UserServiceInterface {
	public int /* id */ searchIdByUsername(String username);

	public void createUser(String firstName, String lastname, String userName);

	public void removeUser(int id);

	public List<User> showAllUsers();
}

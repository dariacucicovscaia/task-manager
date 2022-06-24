package com.stefanini.taskmanager.service;

import java.util.List;


import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.domain.User;

public class UserService {
	UserDAO userDao = new UserDAO();

	
	public int /*id*/ searchIdByUsername(String username) {
		return userDao.get(username).getId();
	}
	
	public void createUser(String firstName, String lastname, String userName ) {
		userDao.put(new User( firstName,lastname, userName));
	}
	
	public List<User> showAllUsers() {
		return userDao.getAll();
		
		
	}
	
	public void removeUser(int id) {
		userDao.remove(id);
	}
}

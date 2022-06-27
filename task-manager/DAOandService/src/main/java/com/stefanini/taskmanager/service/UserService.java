package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.domain.User;

public class UserService implements UserServiceInterface {
	UserDAO userDao = new UserDAO();

	@Override
	public int /* id */ searchIdByUsername(String username) {
		return userDao.get(username).getId();
	}

	@Override
	public void createUser(String firstName, String lastname, String userName) {
		userDao.put(new User(firstName, lastname, userName));
	}

	@Override
	public List<User> showAllUsers() {
		return userDao.getAll();

	}

	@Override
	public void removeUser(int id) {
		userDao.remove(id);
	}
}

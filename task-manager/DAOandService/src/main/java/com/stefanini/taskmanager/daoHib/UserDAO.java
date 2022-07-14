package com.stefanini.taskmanager.daoHib;

import com.stefanini.taskmanager.domain.User;

public class UserDAO extends DAOAbstractImpl<User> implements IUserDAO {
	@Override
	public User findUserByUserName(String userName) {
		User u = getAll().stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElse(null);

		if (u == null) {
			logger.error("The user you are trying to fetch by userName does not exist!!");
		}

		return u;
	}
}

package com.stefanini.taskmanager.daoHib;

import com.stefanini.taskmanager.domain.User;

public interface IUserDAO {
	/**
	 * Searches the User by the UserName
	 * 
	 * @param userName the userName of the User entity
	 * @return User entity
	 */
	User findUserByUserName(String userName);
}

package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.domain.User;

public interface IUserDAO {

	/**
	 * Gets an user entity with the specified username
	 * 
	 * @param username username of the entity
	 * @return the user entity with the specified username
	 */
	User getUseByUserName(String username);

}

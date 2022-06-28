package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.User;
/**
 * abstract method definition for user service 
 * @author DCUCICOV
 *
 */
public interface UserServiceInterface {
	/**
	 * Searches the id by the given username
	 * 
	 * @param username the username of an existing user
	 * @return id of the specified user
	 */
	public int /* id */ searchIdByUsername(String username);

	/**
	 * Creates a user
	 * 
	 * @param firstName first name of the new user
	 * @param lastname  last name of the new user
	 * @param userName  user name of the new user
	 */
	public void createUser(String firstName, String lastname, String userName);

	/**
	 * Removes a user by an id
	 * 
	 * @param id searches the user to remove by the id
	 */
	public void removeUser(int id);

	/**
	 * Shows all the existing users
	 * 
	 * @return a list of all the users
	 */
	public List<User> showAllUsers();
}

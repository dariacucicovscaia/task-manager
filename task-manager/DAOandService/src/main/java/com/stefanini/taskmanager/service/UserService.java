package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.User;

/**
 * abstract method definition for user service
 * 
 * @author DCUCICOV
 *
 */
public interface UserService {
	/**
	 * gets a user with the specified id
	 * 
	 * @param id the id of the user
	 * @return user entity
	 */
	User getUser(int id);

	/**
	 * Creates a user
	 * 
	 * @param firstName first name of the new user
	 * @param lastname  last name of the new user
	 * @param userName  user name of the new user
	 */
	void createUser(String firstName, String lastname, String userName);

	/**
	 * Removes a user by a userName
	 * 
	 * @param userName searches the user to remove
	 */
	void removeUser(String userName);

	/**
	 * Removes a user by a id
	 * 
	 * @param id searches the user to remove
	 */

	void removeUser(int id);

	/**
	 * Shows all the existing users
	 * 
	 * @return a list of all the users
	 */
	List<User> showAllUsers();

	/**
	 * Assigning a task to the user
	 * 
	 * @param userName
	 * @param taskTitle
	 */
	void assignTask(String userName, String taskTitle);

	/**
	 * Creates a user and a task
	 * 
	 * @param firstName       users first name
	 * @param lastName        users last name
	 * @param userName        users user name
	 * @param taskTitle       task title
	 * @param taskDescription task description
	 * 
	 * @return true if the user was successfully created
	 */
	boolean createUserAndAddTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription);

}

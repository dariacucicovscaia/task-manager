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
	public User getUser(int id);

	/**
	 * Creates a user
	 * 
	 * @param firstName first name of the new user
	 * @param lastname  last name of the new user
	 * @param userName  user name of the new user
	 */
	public void createUser(String firstName, String lastname, String userName);

	/**
	 * Removes a user by a userName
	 * 
	 * @param userName searches the user to remove
	 */
	public void removeUser(String userName);

	/**
	 * Removes a user by a id
	 * 
	 * @param id searches the user to remove
	 */

	public void removeUser(int id);

	/**
	 * Shows all the existing users
	 * 
	 * @return a list of all the users
	 */
	public List<User> showAllUsers();

	/**
	 * Assigning a task to the user
	 * 
	 * @param userName
	 * @param taskTitle
	 */
	public void assignTask(String userName, String taskTitle);

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
	public boolean createUserAndAddTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription);

}

package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;

/**
 * abstract method definition for task service
 * 
 * @author DCUCICOV
 *
 */
public interface TaskService {

	/**
	 * Adds the task to a specific user
	 * 
	 * @param id              user id
	 * @param taskTitle       the title of the task
	 * @param taskDescription the description of the task
	 */
	public void addTask(String taskTitle, String taskDescription);

	/**
	 * Displays all tasks
	 * 
	 * @return list of tasks
	 */
	public List<Task> showAllTasks();

	/**
	 * Removes the task of a specific user
	 * 
	 * @param id searches the task to remove by the user id
	 */
	public void removeTask(String userName);

	/**
	 * Shows all the tasks that a user has
	 * 
	 * @param userName searches the tasks a user has by the user name
	 * @return tasks of a user
	 */
	public User getTasksOfAUser(String userName);

	/**
	 * Removes a user by the id
	 * 
	 * @param id - the id of the user to remove
	 */

	public void removeTask(int id);
}

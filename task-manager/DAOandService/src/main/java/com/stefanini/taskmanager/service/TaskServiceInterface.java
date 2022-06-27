package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.Task;

/**
 * 
 * @author DCUCICOV
 *
 */
public interface TaskServiceInterface {
	/**
	 * Searches the username by the id
	 * @param username the username of an existing user
	 * @return id of the specified user
	 */
	public int /* id */ searchIdByUsername(String username);

	/**
	 * Adds the task to a specific user
	 * @param id user id
	 * @param taskTitle the title of the task
	 * @param taskDescription the description of the task
	 */
	public void addTask(int id, String taskTitle, String taskDescription);

	/**
	 * Displays all tasks
	 * @return list of tasks
	 */
	public List<Task> showUserTasks();

	/**
	 * Removes the task of a specific user
	 * @param id searches the task to remove by the user id
	 */
	public void removeTask(int id);

	/**
	 * Shows all the tasks that a user has
	 * @param id searches the tasks a user has by the id
	 * @return tasks of a user
	 */
	public String showUserTask(int id);
}

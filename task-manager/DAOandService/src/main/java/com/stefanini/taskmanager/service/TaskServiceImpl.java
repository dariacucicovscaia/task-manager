package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.daoHib.TaskDAO;
import com.stefanini.taskmanager.daoHib.UserDAO;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;

/**
 * @author DCUCICOV
 *
 */
public class TaskServiceImpl implements TaskService {

	private UserDAO userDao = new UserDAO();
	private TaskDAO taskDao = new TaskDAO();

	@Override
	public void addTask(String taskTitle, String taskDescription) {
		taskDao.create(new Task(taskTitle, taskDescription));
	}

	@Override
	public List<Task> showAllTasks() {
		return taskDao.getAll();
	}

	@Override
	public void removeTask(String taskTitle) {
		taskDao.remove(taskDao.findTaskByTaskTitle(taskTitle).getTaskId());
	}

	@Override
	public void removeTask(int id) {
		taskDao.remove(id);
	}

	@Override
	public User getTasksOfAUser(String userName) {
		return userDao.findUserByUserName(userName);
	}

}

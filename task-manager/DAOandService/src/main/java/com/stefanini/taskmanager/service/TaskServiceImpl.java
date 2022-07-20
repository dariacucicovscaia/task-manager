package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.daoHib.TaskDAO;
import com.stefanini.taskmanager.daoHib.UserDAO;
import com.stefanini.taskmanager.domain.Task;

/**
 * @author DCUCICOV
 *
 */
public class TaskServiceImpl implements TaskService {

	private UserDAO userDao;
	private TaskDAO taskDao;

	public TaskServiceImpl() {
		userDao = new UserDAO();
		taskDao = new TaskDAO();
	}

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
		if (taskDao.findTaskByTaskTitle(taskTitle) != null) {
			taskDao.remove(taskDao.findTaskByTaskTitle(taskTitle).getTaskId());
		}

	}

	@Override
	public void removeTask(int id) {
		taskDao.remove(id);
	}

	@Override
	public String getTasksOfAUser(String userName) {
		if (userDao.findUserByUserName(userName) == null) {
			return "User does not exist, try another UserName!!";

		}
		return userDao.findUserByUserName(userName).toString();

	}

}

package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.dao.TaskDAO;
import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.domain.Task;
/**
 * @author DCUCICOV
 *
 */
public class TaskService implements TaskServiceInterface {

	TaskDAO taskdao = new TaskDAO();
	UserDAO userdao = new UserDAO();

	@Override
	public int /* id */ searchIdByUsername(String username) {
		return userdao.get(username).getId();
	}

	@Override
	public void addTask(int id, String taskTitle, String taskDescription) {
		taskdao.put(new Task(id, taskTitle, taskDescription));
	}

	@Override
	public List<Task> showUserTasks() {
		return taskdao.getAll();
	}

	@Override
	public void removeTask(int id) {
		taskdao.remove(id);
	}

	@Override
	public String showUserTask(int id) {
		return userdao.get(id) + " " + taskdao.getAllWithId(id);
	}
}

package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.dao.TaskDAO;
import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.domain.Task;

public class TaskService {

	TaskDAO taskdao = new TaskDAO();
	UserDAO userdao = new UserDAO();


	
	public int /*id*/ searchIdByUsername(String username) {
		return userdao.get(username).getId();
	}
	
	public void addTask(int id, String taskTitle, String taskDescription) {
		taskdao.put(new Task(id, taskTitle, taskDescription));
	}

	public List<Task> showUserTasks() {
		return taskdao.getAll();

	}

	public void removeTask(int id) {
		taskdao.remove(id);
	}

	public String showUserTask(int id) {

		return userdao.get(id)+ " " + taskdao.getAllWithId(id) ;
	}
}

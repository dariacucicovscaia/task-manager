package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.domain.Task;

public interface TaskServiceInterface {
	public int /* id */ searchIdByUsername(String username);

	public void addTask(int id, String taskTitle, String taskDescription);

	public List<Task> showUserTasks();

	public void removeTask(int id);

	public String showUserTask(int id);
}

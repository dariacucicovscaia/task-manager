package com.stefanini.taskmanager.daoHib;

import com.stefanini.taskmanager.domain.Task;

public class TaskDAO extends DAOAbstractImpl<Task> implements ITaskDAO {
	@Override
	public Task findTaskByTaskTitle(String taskTitle) {
		Task t = getAll().stream().filter(task -> task.getTaskTitle().equals(taskTitle)).findFirst().orElse(null);

		if (t == null) {
			logger.error("The task you are trying to fetch by taskTitle does not exist!!");
		}

		return t;
	}
}

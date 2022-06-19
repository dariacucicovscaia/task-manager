package com.stefanini.taskmanager.daoHib;

import com.stefanini.taskmanager.domain.Task;

public interface ITaskDAO {
	/**
	 * Searches the Task by the TaskTitle
	 * 
	 * @param taskTitle the taskTitle of the Task entity
	 * @return Task entity
	 */
	Task findTaskByTaskTitle(String taskTitle);
}

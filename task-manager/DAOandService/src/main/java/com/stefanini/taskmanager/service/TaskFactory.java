package com.stefanini.taskmanager.service;

import java.sql.SQLException;

public class TaskFactory {
	public Task createTask(String userName, String tasktitle, String taskdescription)
			throws SQLException, ClassNotFoundException {

		Task task = new Task();
//check if user exists
		task = new Task(userName, tasktitle, taskdescription);

		return task;

	}
}

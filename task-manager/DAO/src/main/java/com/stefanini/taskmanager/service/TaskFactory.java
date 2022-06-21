package com.stefanini.taskmanager.service;

import java.sql.SQLException;

public class TaskFactory {
	public Task createTask( String userName, String tasktitle, String taskdescription) throws SQLException, ClassNotFoundException {
		UserDAO user = new UserDAO();
		Task task = new Task();
		
			task = new Task(user.get(userName).getUuid().toString(), userName, tasktitle, taskdescription) ;
		
		
		return task;
		
	}
}

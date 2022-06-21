package com.stefanini.taskmanager.service;

import java.util.UUID;

public class Task {
	private String uuid;
	private String userName;
	private String taskTitle;
	private String taskDescription;

	public Task(String uuid, String userName, String taskTitle, String taskDescription) {
		super();
		setUuid(uuid);
		setUserName(userName);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}

	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Override
	public String toString() {
		return "Task [userName=" + userName + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription + "]";
	}

}

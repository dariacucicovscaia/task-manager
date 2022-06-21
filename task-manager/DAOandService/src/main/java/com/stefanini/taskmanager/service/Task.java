package com.stefanini.taskmanager.service;

public class Task {
	private String userName;
	private String taskTitle;
	private String taskDescription;

	public Task( String userName, String taskTitle, String taskDescription) {
		super();
		
		setUserName(userName);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}

	public Task() {
		// TODO Auto-generated constructor stub
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

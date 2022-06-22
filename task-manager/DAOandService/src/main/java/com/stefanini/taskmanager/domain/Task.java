package com.stefanini.taskmanager.domain;

public class Task {
	private int id;
	private String taskTitle;
	private String taskDescription;

	public Task(int id,  String taskTitle, String taskDescription) {
		super();
		setId(id);
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}

	public Task() {
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription + "]";
	}

}

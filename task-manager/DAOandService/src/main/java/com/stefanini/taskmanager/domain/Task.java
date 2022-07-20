package com.stefanini.taskmanager.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tasks")
public class Task {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Id
	private int id;
	private String taskTitle;
	private String taskDescription;

	@Transient
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_tasks", inverseJoinColumns = @JoinColumn(name = "user_id"), joinColumns = @JoinColumn(name = "task_id"))
	private List<User> users;

	public Task() {

	}

	public Task(int id, String taskTitle, String taskDescription) {
		this.id = id;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
	}

	public Task(String taskTitle, String taskDescription) {
		setTaskTitle(taskTitle);
		setTaskDescription(taskDescription);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public int getTaskId() {
		return id;
	}

	public void setTaskId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + id + ", taskTitle=" + taskTitle + ", taskDescription=" + taskDescription + "]";
	}

}
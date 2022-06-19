package com.stefanini.taskmanager.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "userName")
	private String userName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_tasks", inverseJoinColumns = @JoinColumn(name = "task_id"), joinColumns = @JoinColumn(name = "user_id"))
	private List<Task> tasks = new ArrayList<>();

	public User() {

	}

	public User(int id, String firstName, String lastName, String userName) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public User(String firstName, String lastName, String userName) {
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", tasks=" + tasks + "]";
	}

}
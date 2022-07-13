package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class CreateUserAndAddTask extends OpsWithArguments implements Command {
	private UserService userservice;

	public CreateUserAndAddTask(String[] args) {
		super(args);
		userservice = new UserServiceImpl();
	}

	@Override
	public void execute() {
		String firstName = read(args[1]);
		String lastName = read(args[2]);
		String userName = read(args[3]);
		String taskTitle = read(args[4]);
		String taskDescription = read(args[5]);

		userservice.createUserAndAddTask(firstName, lastName, userName, taskTitle, taskDescription);

	}
}

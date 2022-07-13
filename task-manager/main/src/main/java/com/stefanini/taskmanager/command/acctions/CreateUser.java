package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class CreateUser extends OpsWithArguments implements Command {
	private UserService userservice;

	public CreateUser(String[] args) {
		super(args);
		userservice = new UserServiceImpl();
	}

	/**
	 * creates a user via execute command
	 */
	@Override
	public void execute() {
		String firstName = read(args[1]);
		String lastName = read(args[2]);
		String userName = read(args[3]);

		userservice.createUser(firstName, lastName, userName);

	}

}

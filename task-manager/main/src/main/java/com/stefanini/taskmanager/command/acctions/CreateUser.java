package com.stefanini.taskmanager.command.acctions;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.CLIApp;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;

public class CreateUser extends OpsWithArguments implements Command {
	private UserService userservice = new UserService();

	public CreateUser(String[] args) {
		super(args);

	}

	/**
	 * creates a user via execute command
	 */
	@Override
	public void execute() {
		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();

		String firstName = read(args[1]);
		String lastName = read(args[2]);
		String userName = read(args[3]);

		userservice.createUser(firstName, lastName, userName);

		logger.trace("Operation successful\nUser created!");

	}

}

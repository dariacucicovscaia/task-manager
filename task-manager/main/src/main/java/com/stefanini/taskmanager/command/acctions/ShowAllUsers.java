package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class ShowAllUsers extends OpsWithArguments implements Command {

	private UserService userservice = new UserServiceImpl();

	public ShowAllUsers(String[] args) {
		super(args);
	}

	@Override
	public void execute() {
		userservice.showAllUsers().stream().forEach(System.out::println);
		;

	}

}

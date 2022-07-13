package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class RemoveUser extends OpsWithArguments implements Command {
	private UserService userservice;

	public RemoveUser(String args[]) {
		super(args);
		userservice = new UserServiceImpl();
	}

	@Override
	public void execute() {

		String userName = read(args[1]);

		userservice.removeUser(userName);

	}

}

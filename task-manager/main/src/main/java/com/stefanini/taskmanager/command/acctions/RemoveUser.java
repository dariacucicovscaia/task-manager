package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class RemoveUser extends OpsWithArguments implements Command {
	private UserService userservice = new UserServiceImpl();

	public RemoveUser(String args[]) {
		super(args);

	}

	@Override
	public void execute() {

		String userName = read(args[1]);

		userservice.removeUser(userName);

	}

}

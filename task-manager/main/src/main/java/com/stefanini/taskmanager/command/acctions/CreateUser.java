package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.ArgumentReader;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;

public class CreateUser extends OpsWithArguments implements Command {
	private UserService userservice = new UserService();

	public CreateUser(String[] args) {
		super(args);
		
	}

	public void execute() {
		ArgumentReader argread = new ArgumentReader();

		String firstName = argread.read(args[1]);
		String lastName = argread.read(args[2]);
		String userName = argread.read(args[3]);

		userservice.createUser(firstName, lastName, userName);
		
	}

}

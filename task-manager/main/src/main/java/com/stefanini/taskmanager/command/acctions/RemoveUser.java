package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.ArgumentReader;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;

public class RemoveUser extends OpsWithArguments implements Command {
	private UserService userservice = new UserService();

	public RemoveUser(String args[]) {
		super(args);

	}

	@Override
	public void execute() {
		ArgumentReader argread = new ArgumentReader();
		String id = argread.read(args[1]);

		userservice.removeUser(Integer.parseInt(id));
	}

}

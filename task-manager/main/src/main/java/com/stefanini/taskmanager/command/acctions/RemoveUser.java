package com.stefanini.taskmanager.command.acctions;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.CLIApp;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;

public class RemoveUser extends OpsWithArguments implements Command {
	private UserService userservice = new UserService();

	public RemoveUser(String args[]) {
		super(args);

	}

	@Override
	public void execute() {
		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();
		
		String username = read(args[1]);

		userservice.removeUser(userservice.searchIdByUsername(username));
		logger.trace("User removed");
	}

}

package com.stefanini.taskmanager.command;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.CLIApp;
import com.stefanini.taskmanager.command.acctions.AddTask;
import com.stefanini.taskmanager.command.acctions.Command;
import com.stefanini.taskmanager.command.acctions.CreateUser;
import com.stefanini.taskmanager.command.acctions.RemoveTask;
import com.stefanini.taskmanager.command.acctions.RemoveUser;
import com.stefanini.taskmanager.command.acctions.ShowAllUsers;
import com.stefanini.taskmanager.command.acctions.ShowAllTasks;
import com.stefanini.taskmanager.command.acctions.ShowUsersTask;

public class ChoseCommand implements ChoseCommandInterface {

	Logger logger = Logger.getLogger(ChoseCommand.class);

	@Override
	public Command choseCommand(String[] args) {

		BasicConfigurator.configure();

		switch (args[0]) {
		case "createUser":
			return new CreateUser(args);
		case "addTask":
			return new AddTask(args);
		case "showAllUsers":
			return new ShowAllUsers(args);
		case "showAllTasks":
			return new ShowAllTasks(args);
		case "removeUser":
			return new RemoveUser(args);
		case "removeTask":
			return new RemoveTask(args);
		case "showUsersTask":
			return new ShowUsersTask(args);
		default:
			return null;
			
		}
	}

}

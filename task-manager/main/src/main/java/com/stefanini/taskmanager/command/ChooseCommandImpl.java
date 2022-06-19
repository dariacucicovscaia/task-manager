package com.stefanini.taskmanager.command;

import com.stefanini.taskmanager.command.acctions.AddTask;
import com.stefanini.taskmanager.command.acctions.Command;
import com.stefanini.taskmanager.command.acctions.CreateUser;
import com.stefanini.taskmanager.command.acctions.CreateUserAndAddTask;
import com.stefanini.taskmanager.command.acctions.RemoveTask;
import com.stefanini.taskmanager.command.acctions.RemoveUser;
import com.stefanini.taskmanager.command.acctions.ShowAllTasks;
import com.stefanini.taskmanager.command.acctions.ShowAllUsers;
import com.stefanini.taskmanager.command.acctions.ShowTasksOfAUser;

public class ChooseCommandImpl implements ChooseCommand {

	@Override
	public Command chooseCommand(String[] args) {

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
		case "showTasksOfAUser":
			return new ShowTasksOfAUser(args);
		case "createUserAndAddTask":
			return new CreateUserAndAddTask(args);
		default:
			return null;

		}
	}

}

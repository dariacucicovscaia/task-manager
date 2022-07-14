package com.stefanini.taskmanager.command;

import java.util.Scanner;

import com.stefanini.taskmanager.command.acctions.AddTask;
import com.stefanini.taskmanager.command.acctions.AssignTask;
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
	public Command chooseCommand(Scanner scanner) {
		String firstArg = scanner.next();

		switch (firstArg) {
		case "createUser":
			return new CreateUser(scanner);
		case "addTask":
			return new AddTask(scanner);
		case "assignTask":
			return new AssignTask(scanner);
		case "showAllUsers":
			return new ShowAllUsers(scanner);
		case "showAllTasks":
			return new ShowAllTasks(scanner);
		case "removeUser":
			return new RemoveUser(scanner);
		case "removeTask":
			return new RemoveTask(scanner);
		case "showTasksOfAUser":
			return new ShowTasksOfAUser(scanner);
		case "createUserAndAddTask":
			return new CreateUserAndAddTask(scanner);
		default:
			return null;

		}
	}

}

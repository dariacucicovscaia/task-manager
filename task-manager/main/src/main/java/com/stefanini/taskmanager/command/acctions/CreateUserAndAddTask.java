package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class CreateUserAndAddTask extends OpsWithArguments implements Command {
	private UserService userservice;

	public CreateUserAndAddTask(Scanner scanner) {
		super(scanner);
		userservice = new UserServiceImpl();
	}

	@Override
	public void execute() {
		String firstName = valueBetweenApostrohe(scanner.next());
		String lastName = valueBetweenApostrohe(scanner.next());
		String userName = valueBetweenApostrohe(scanner.next());
		String taskTitle = valueBetweenApostrohe(scanner.next());
		String taskDescription = valueBetweenApostrohe(scanner.next());

		userservice.createUserAndAddTask(firstName, lastName, userName, taskTitle, taskDescription);

	}
}

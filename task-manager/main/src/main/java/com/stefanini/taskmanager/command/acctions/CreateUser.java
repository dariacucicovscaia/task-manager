package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class CreateUser extends OpsWithArguments implements Command {
	private UserService userservice;

	public CreateUser(Scanner scanner) {
		super(scanner);
		userservice = new UserServiceImpl();
	}

	@Override
	public void execute() {
		String firstName = valueBetweenApostrohe(scanner.next());
		String lastName = valueBetweenApostrohe(scanner.next());
		String userName = valueBetweenApostrohe(scanner.next());

		userservice.createUser(firstName, lastName, userName);

	}

}

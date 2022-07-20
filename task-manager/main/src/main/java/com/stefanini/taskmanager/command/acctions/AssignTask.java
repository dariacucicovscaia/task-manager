package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class AssignTask extends OpsWithArguments implements Command {
	private UserService userservice;

	public AssignTask(Scanner scanner) {
		super(scanner);
		userservice = new UserServiceImpl();
	}

	@Override
	public synchronized void execute() {

		String userName = valueBetweenApostrohe(scanner.next());
		String taskTitle = valueBetweenApostrohe(scanner.next());

		userservice.assignTask(userName, taskTitle);
		;

	}

}

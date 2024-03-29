package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.UserService;
import com.stefanini.taskmanager.service.UserServiceImpl;

public class ShowAllUsers extends OpsWithArguments implements Command {

	private UserService userservice;

	public ShowAllUsers(Scanner scanner) {
		super(scanner);
		userservice = new UserServiceImpl();
	}

	@Override
	public void execute() {
		userservice.showAllUsers().stream().forEach(System.err::println);

	}

}

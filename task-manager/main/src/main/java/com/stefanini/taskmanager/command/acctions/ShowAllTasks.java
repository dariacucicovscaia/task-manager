package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class ShowAllTasks extends OpsWithArguments implements Command {
	private TaskService taskservice;

	public ShowAllTasks(Scanner scanner) {
		super(scanner);
		taskservice = new TaskServiceImpl();
	}

	@Override
	public void execute() {
		taskservice.showAllTasks().stream().forEach(System.err::println);

	}

}

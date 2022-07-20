package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class ShowTasksOfAUser extends OpsWithArguments implements Command {
	private TaskService taskService;

	public ShowTasksOfAUser(Scanner scanner) {
		super(scanner);
		taskService = new TaskServiceImpl();
	}

	@Override
	public synchronized void execute() {
		String username = valueBetweenApostrohe(scanner.next());
		System.out.println(taskService.getTasksOfAUser(username));
	}
}

package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class AddTask extends OpsWithArguments implements Command {
	private TaskService taskservice;

	public AddTask(Scanner args) {
		super(args);
		taskservice = new TaskServiceImpl();
	}

	/**
	 * Adds a task via execute command
	 */
	@Override
	public void execute() {

		String taskTitle = valueBetweenApostrohe(scanner.next());
		String taskDescription = valueBetweenApostrohe(scanner.next());

		taskservice.addTask(taskTitle, taskDescription);

	}

}

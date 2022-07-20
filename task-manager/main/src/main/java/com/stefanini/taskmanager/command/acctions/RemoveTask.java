package com.stefanini.taskmanager.command.acctions;

import java.util.Scanner;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class RemoveTask extends OpsWithArguments implements Command {
	private TaskService taskservice;

	public RemoveTask(Scanner scanner) {
		super(scanner);
		taskservice = new TaskServiceImpl();
	}

	@Override
	public void execute() {

		String id = valueBetweenApostrohe(scanner.next());

		taskservice.removeTask(Integer.parseInt(id));
	}
}

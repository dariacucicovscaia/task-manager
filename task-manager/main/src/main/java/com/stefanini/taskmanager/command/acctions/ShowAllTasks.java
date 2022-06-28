package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class ShowAllTasks extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskServiceImpl();

	public ShowAllTasks(String[] args) {
		super(args);
	}

	@Override
	public void execute() {
		taskservice.showAllTasks().stream().forEach(System.out::println);

	}

}

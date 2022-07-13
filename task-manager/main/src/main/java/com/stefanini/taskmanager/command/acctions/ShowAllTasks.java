package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class ShowAllTasks extends OpsWithArguments implements Command {
	private TaskService taskservice;

	public ShowAllTasks(String[] args) {
		super(args);
		taskservice = new TaskServiceImpl();
	}

	@Override
	public void execute() {
		taskservice.showAllTasks().stream().forEach(System.out::println);

	}

}

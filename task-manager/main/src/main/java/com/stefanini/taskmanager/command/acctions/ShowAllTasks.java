package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;

public class ShowAllTasks extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskService();

	public ShowAllTasks(String[] args) {
		super(args);
	}

	@Override
	public void execute() {
		taskservice.showUserTasks().stream().forEach(System.out::println);

	}

}

package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class ShowTasksOfAUser extends OpsWithArguments implements Command {
	private TaskService taskService;

	public ShowTasksOfAUser(String[] args) {
		super(args);
		taskService = new TaskServiceImpl();
	}

	@Override
	public void execute() {
		String username = read(args[1]);
		System.out.println(taskService.getTasksOfAUser(username));
	}
}

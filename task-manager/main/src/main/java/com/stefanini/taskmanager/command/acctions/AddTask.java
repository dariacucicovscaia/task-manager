package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class AddTask extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskServiceImpl();

	public AddTask(String[] args) {
		super(args);
	}

	/**
	 * Adds a task via execute command
	 */
	@Override
	public void execute() {

		String taskTitle = read(args[2]);
		String taskDescription = read(args[3]);

		taskservice.addTask(taskTitle, taskDescription);

	}

}

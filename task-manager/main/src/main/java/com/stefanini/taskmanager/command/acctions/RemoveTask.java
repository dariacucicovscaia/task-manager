package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;
import com.stefanini.taskmanager.service.TaskServiceImpl;

public class RemoveTask extends OpsWithArguments implements Command {
	private TaskService taskservice;

	public RemoveTask(String args[]) {
		super(args);
		taskservice = new TaskServiceImpl();
	}

	@Override
	public void execute() {

		String id = read(args[1]);

		taskservice.removeTask(Integer.parseInt(id));
	}
}

package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;

public class RemoveTask extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskService();

	public RemoveTask(String args[]) {
		super(args);

	}

	@Override
	public void execute() {

		String id = read(args[1]);

		taskservice.removeTask(Integer.parseInt(id));
	}
}

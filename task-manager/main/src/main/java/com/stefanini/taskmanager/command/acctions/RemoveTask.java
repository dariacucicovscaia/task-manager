package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.ArgumentReader;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;

public class RemoveTask extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskService();

	public RemoveTask(String args[]) {
		super(args);

	}

	@Override
	public void execute() {
		ArgumentReader argread = new ArgumentReader();
		String id = argread.read(args[1]);

		taskservice.removeTask(Integer.parseInt(id));
	}
}

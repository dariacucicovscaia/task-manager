package com.stefanini.taskmanager.command.acctions;

import com.stefanini.taskmanager.command.ArgumentReader;
import com.stefanini.taskmanager.command.Command;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;

public class AddTask extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskService();
	
	public AddTask(String[] args) {
		super(args);
		
	}

	public void execute() {

		
		ArgumentReader argread = new ArgumentReader();

		String id = argread.read(args[1]);
		String taskTitle = argread.read(args[2]);
		String taskDescription = argread.read(args[3]);
		
		 taskservice.addTask(Integer.parseInt(id), taskTitle, taskDescription);
	}


}

package com.stefanini.taskmanager.command.acctions;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.CLIApp;
import com.stefanini.taskmanager.command.OpsWithArguments;
import com.stefanini.taskmanager.service.TaskService;

public class AddTask extends OpsWithArguments implements Command {
	private TaskService taskservice = new TaskService();

	public AddTask(String[] args) {
		super(args);

	}

	public void execute() {

		Logger logger = Logger.getLogger(CLIApp.class);
		BasicConfigurator.configure();
		
		String username = read(args[1]);
		String taskTitle =read(args[2]);
		String taskDescription = read(args[3]);

		int id = taskservice.searchIdByUsername(username);
		taskservice.addTask(id, taskTitle, taskDescription);
		logger.trace("Task added");
	}

}

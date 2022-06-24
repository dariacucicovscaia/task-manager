package com.stefanini.taskmanager.command;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.stefanini.taskmanager.CLIApp;
import com.stefanini.taskmanager.command.acctions.AddTask;
import com.stefanini.taskmanager.command.acctions.CreateUser;
import com.stefanini.taskmanager.command.acctions.RemoveTask;
import com.stefanini.taskmanager.command.acctions.RemoveUser;
import com.stefanini.taskmanager.command.acctions.ShowAllUsers;
import com.stefanini.taskmanager.command.acctions.ShowAllTasks;
import com.stefanini.taskmanager.command.acctions.ShowUsersTask;

public class ChoseCommand implements ChoseCommandInterface {

	Logger logger = Logger.getLogger(ChoseCommand.class);
	
	
	@Override
	public void choseCommand(String[] args) {
		
		BasicConfigurator.configure();
		
		switch (args[0]) {
		case "createUser":
			CreateUser createuser = new CreateUser(args);
			createuser.execute();
			break;
		case "addTask":
			AddTask addtask = new AddTask(args);
			addtask.execute();
			break;
		case "showAllUsers":
			ShowAllUsers showallusers = new ShowAllUsers(args);
			showallusers.execute();
			break;
		case "showAllTasks":
			ShowAllTasks ShowAllTasks = new ShowAllTasks(args);
			ShowAllTasks.execute();
			break;
		case "removeUser":
			RemoveUser removeUser = new RemoveUser(args);
			removeUser.execute();
			break;
		case "removeTask":
			RemoveTask removeTask = new RemoveTask(args);
			removeTask.execute();
			break;
		case "showUsersTask":
			ShowUsersTask showUsersTask = new ShowUsersTask(args);
			showUsersTask.execute();
			break;
		default:
			logger.error("no args[0]");;
		}
	}

}

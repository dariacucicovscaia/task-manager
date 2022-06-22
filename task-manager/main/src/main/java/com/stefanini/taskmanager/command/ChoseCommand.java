package com.stefanini.taskmanager.command;

import com.stefanini.taskmanager.command.acctions.AddTask;
import com.stefanini.taskmanager.command.acctions.CreateUser;
import com.stefanini.taskmanager.command.acctions.RemoveUser;
import com.stefanini.taskmanager.command.acctions.ShowAllUsers;
import com.stefanini.taskmanager.command.acctions.ShowUserTasks;

public class ChoseCommand implements ChoseCommandInterface {

	@Override
	public void choseCommand(String[] args) {
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
		case "showUserTasks":
			ShowUserTasks showusertasks = new ShowUserTasks(args);
			showusertasks.execute();
			break;
		case "removeUser":
			RemoveUser removeUser = new RemoveUser(args);
			removeUser.execute();
			break;
		default:
			System.out.println("error");;
		}
	}

}

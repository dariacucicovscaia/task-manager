package com.stefanini.taskmanager;

import java.io.IOException;
import java.sql.SQLException;
import com.stefanini.taskmanager.service.TaskDAO;
import com.stefanini.taskmanager.service.TaskFactory;
import com.stefanini.taskmanager.service.UserDAO;
import com.stefanini.taskmanager.service.UserFactory;

public class CLIApp {
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException {

		ArgumentsReader argread = new ArgumentsReader();
		UserDAO userrepo = new UserDAO();
		UserFactory uf = new UserFactory();
		TaskDAO taskrepo = new TaskDAO();
		TaskFactory tf = new TaskFactory();

		String firstName = null, lastName = null, userName = null, taskTitle = null, taskDescription = null;
		/**
		 * creates a user if console input = -createUser -fn='FirstName' -ln='LastName'
		 * -un='UserName'
		 * 
		 */

		if (args[0].equals("-createUser")) {
			firstName = argread.read(args[1]);
			lastName = argread.read(args[2]);
			userName = argread.read(args[3]);
			
			userrepo.put(uf.createUser(firstName, lastName, userName));

		}

		/**
		 * shows users if console input = -showAllUsers
		 */
		if (args[0].equals("-showAllUsers")) {
			userrepo.getAll().stream().forEach(System.out::println);
		}

		/**
		 * adds a task to a specific user if console input = -addTask -un='UserName'
		 * -tt='Task Title' -td='Task Description'
		 */

		// taskrepo.addTasks("UserName", "titletask", "description");
		if (args[0].equals("-addTask")) {
			userName = argread.read(args[1]);
			taskTitle = argread.read(args[2]);
			taskDescription = argread.read(args[3]);

			taskrepo.put(tf.createTask(userName, taskTitle, taskDescription));

		}

		/**
		 * shows the task of the user if console input = -showTasks -un='userName'
		 */
		if (args[0].equals("-showTasks")) {
			taskrepo.getAll().stream().forEach(System.out::println);
		}

	}
}
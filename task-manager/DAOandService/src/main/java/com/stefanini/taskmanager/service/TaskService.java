package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.dao.TaskDAO;
import com.stefanini.taskmanager.domain.Task;

public class TaskService {

	TaskDAO taskdao = new TaskDAO();
	Task u = new Task();

	public void addTask(int id, String lastname, String userName ) {
		taskdao.put(new Task( id,lastname, userName));
	}
	
	public List<Task> showUserTasks() {
		return taskdao.getAll();
		
	}
	
	public void removeTask(int id) {
		taskdao.remove(id);
	}
}




///**
// * adds a task to a specific user if console input = -addTask -un='UserName' -tt='TaskTitle' -td='TaskDescription'
// */
//
//
//if (args[0].equals("-addTask")) {
//	userName = argread.read(args[1]);
//	taskTitle = argread.read(args[2]);
//	taskDescription = argread.read(args[3]);
//
//	taskrepo.put(tf.createTask(userName, taskTitle, taskDescription));
//
//}
//
///**
// * shows all task of the all users if console input = -showAllTasks 
// */
//if (args[0].equals("-showAllTasks")) {
//	taskrepo.getAll().stream().forEach(System.out::println);
//}
//
///**
// * shows the task of the user if console input = -showTasks -un='userName'
// */
//if (args[0].equals("-showTasks")) {
//	userName = argread.read(args[1]);
//	System.out.println(taskrepo.get(userName));
//	
//}
///**
// * shows the task of the user if console input = -removeUser
// */
//if (args[0].equals("-removeUser")) {
//	userName = argread.read(args[1]);
//	userrepo.remove(userName);
//}
///**
// * shows the task of the user if console input = -removeTask -un='userName'
// */
//if (args[0].equals("-removeTask")) {
//	userName = argread.read(args[1]);
//	taskrepo.remove(userName);
//}
//
//}
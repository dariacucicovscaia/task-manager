package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.daoHib.TaskDAO;
import com.stefanini.taskmanager.daoHib.UserDAO;
import com.stefanini.taskmanager.domain.Task;
import com.stefanini.taskmanager.domain.User;
import com.stefanini.taskmanager.sendMail.SendMail;

/**
 * 
 * @author DCUCICOV
 *
 * 
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDao = new UserDAO();
	private TaskDAO taskDao = new TaskDAO();

	@Override
	public User getUser(int id) {
		return userDao.get(id);
	}

	@SendMail
	@Override
	public void createUser(String firstName, String lastName, String userName) {
		userDao.create(new User(firstName, lastName, userName));
	}

	@Override
	public List<User> showAllUsers() {
		return userDao.getAll();

	}

	@Override
	public void removeUser(String userName) {
		int Id = userDao.findUserByUserName(userName).getId();
		userDao.remove(Id);
	}

	@Override
	public void removeUser(int id) {
		userDao.remove(id);
	}

	@Override
	@SendMail
	public void assignTask(String userName, String taskTitle) {
		User user = userDao.findUserByUserName(userName);
		user.addTask(taskDao.findTaskByTaskTitle(taskTitle));

		userDao.update(user);
	}

	@Override
	@SendMail
	public boolean createUserAndAddTask(String firstName, String lastName, String userName, String taskTitle,
			String taskDescription) {
		User u = new User(firstName, lastName, userName);
		u.addTask(new Task(taskTitle, taskDescription));

		userDao.create(u);
		return true;

	}

}
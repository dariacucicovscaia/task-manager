package com.stefanini.taskmanager.service;

import java.sql.SQLException;

import com.stefanini.taskmanager.dao.DAOAbstract;

public class TaskDAO extends DAOAbstract<Task> {
	public TaskDAO() throws SQLException {
		super();
	}
}

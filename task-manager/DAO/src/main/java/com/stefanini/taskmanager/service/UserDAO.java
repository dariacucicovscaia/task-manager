package com.stefanini.taskmanager.service;

import java.sql.SQLException;

import com.stefanini.taskmanager.dao.DAOAbstract;

public class UserDAO extends DAOAbstract<User>{
	
	public UserDAO() throws SQLException {
		super();
	}
}

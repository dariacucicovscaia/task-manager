package com.stefanini.taskmanager.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
	List<T> getAll() throws SQLException;

	void put(T entity) throws SQLException;

	T get(String userName) throws SQLException, ClassNotFoundException, NoSuchMethodException;

	void remove(String username) throws SQLException;

}
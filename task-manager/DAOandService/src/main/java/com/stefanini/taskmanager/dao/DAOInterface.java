package com.stefanini.taskmanager.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
	List<T> getAll() ;

	void put(T entity) ;

	T get(String userName) throws SQLException, ClassNotFoundException, NoSuchMethodException;

	void remove(int id) ;

}
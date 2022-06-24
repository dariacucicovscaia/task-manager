package com.stefanini.taskmanager.dao;

import java.util.List;

public interface DAOInterface<T> {
	List<T> getAll();

	List<T> getAllWithId(int id);

	void put(T entity);

	T get(int id);

	T get(String username);

	void remove(int id);

}
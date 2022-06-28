package com.stefanini.taskmanager.dao;

import java.util.List;

/**
 * 
 * @author DCUCICOV
 *
 * @param <T> with generics specifies witch entity to operate with
 */
public interface DAO<T> {
	/**
	 * Gets all the entitys
	 * 
	 * @return a list of entitys
	 */
	List<T> getAll();

	/**
	 * Gets all entitys with the specified id
	 * 
	 * @param id identifier of an entity
	 * @return entitys with the specified id
	 */
	List<T> getById(int id);

	/**
	 * Puts an entity in the database
	 * 
	 * @param entity the entity
	 */
	void put(T entity);

	/**
	 * Gets an entity with the specified id
	 * 
	 * @param id id of the entity
	 * @return the entity with the specified id
	 */
	T get(int id);

	/**
	 * Removes a row with the specified id
	 * 
	 * @param id the id of the entity
	 */
	void remove(int id);

}
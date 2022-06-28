package com.stefanini.taskmanager.daoHib;

import java.util.List;

/**
 * @author DCUCICOV
 *
 * @param <T> with generics specifies witch entity to operate with
 */
public interface IGenericDao<T> {
	/**
	 * Gets all the entitys
	 * 
	 * @return a list of entitys
	 */
	List<T> getAll();

	/**
	 * Puts an entity in the database
	 * 
	 * @param entity the entity
	 */
	void create(T entity);

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

	/**
	 * Updates an entity
	 * 
	 * @param entity the entity to update
	 */
	void update(T entity);

}

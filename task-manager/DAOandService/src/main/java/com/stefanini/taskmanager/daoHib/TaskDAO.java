package com.stefanini.taskmanager.daoHib;

import javax.persistence.TypedQuery;

import com.stefanini.taskmanager.domain.Task;

public class TaskDAO extends DAOAbstractImpl<Task> implements ITaskDAO {
	@Override
	public Task findTaskByTaskTitle(String taskTitle) {
		TypedQuery query = entityManager.createQuery("select a from Task a where a.taskTitle = ?1", Task.class);
		query.setParameter(1, taskTitle);
		return (Task) query.getSingleResult();
	}
}

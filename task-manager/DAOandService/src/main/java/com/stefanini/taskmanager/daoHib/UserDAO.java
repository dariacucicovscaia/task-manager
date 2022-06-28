package com.stefanini.taskmanager.daoHib;

import javax.persistence.TypedQuery;

import com.stefanini.taskmanager.domain.User;

public class UserDAO extends DAOAbstractImpl<User> implements IUserDAO {
	@Override
	public User findUserByUserName(String userName) {
		TypedQuery query = entityManager.createQuery("select a from User a where a.userName = ?1", User.class);
		query.setParameter(1, userName);
		return (User) query.getSingleResult();
	}
}

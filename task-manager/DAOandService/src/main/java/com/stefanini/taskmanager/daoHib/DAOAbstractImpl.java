package com.stefanini.taskmanager.daoHib;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

public abstract class DAOAbstractImpl<T> implements IGenericDao<T> {

	EntityManager entityManager = getEntityManager();
	private Class<T> clazz;
	private EntityTransaction transaction = null;
	private Logger logger = Logger.getLogger(DAOAbstractImpl.class);

	public DAOAbstractImpl() {
		ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) t.getActualTypeArguments()[0];

	}

	private EntityManager getEntityManager() {
		return HibernateUtil.getEntityManager();
	}

	private void shutdown() {
		HibernateUtil.shutdown();
	}

	@Override
	public List<T> getAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public void update(T entity) {
		try {

			transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.merge(entity);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getMessage());
		} finally {
			shutdown();
		}
	}

	@Override
	public void create(T entity) {
		try {
			transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getMessage());

		} finally {
			shutdown();
		}
	}

	@Override
	public T get(int id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void remove(int id) {
		try {
			transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.remove(get(id));
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			logger.error(e.getMessage());
		} finally {
			shutdown();
		}
	}

}
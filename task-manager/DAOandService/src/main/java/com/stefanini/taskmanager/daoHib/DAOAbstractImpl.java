package com.stefanini.taskmanager.daoHib;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

public abstract class DAOAbstractImpl<T> implements IGenericDao<T> {

	EntityManager entityManager = getEntityManager();
	private Class<T> clazz;
	private EntityTransaction transaction = null;
	protected Logger logger = Logger.getLogger(DAOAbstractImpl.class);
	protected CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

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
		CriteriaQuery<T> cq = criteriaBuilder.createQuery(clazz);
		Root<T> from = cq.from(clazz);
		cq.select(from);

		TypedQuery<T> q = entityManager.createQuery(cq);
		List<T> allItems = q.getResultList();

		return allItems;

	}

	@Override
	public void update(T entity) {
		transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.merge(entity);
		transaction.commit();

	}

	@Override
	public void create(T entity) {
		transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(entity);
		transaction.commit();

	}

	@Override
	public T get(int id) {

		CriteriaQuery<T> cq = criteriaBuilder.createQuery(clazz);
		Root<T> from = cq.from(clazz);

		cq.where(criteriaBuilder.equal(from.get("id"), id));

		TypedQuery<T> q = entityManager.createQuery(cq);
		List<T> allItems = q.getResultList();

		return allItems.get(0);

	}

	@Override
	public void remove(int id) {

		CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(clazz);

		Root<T> root = criteriaDelete.from(clazz);
		criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));

		transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.createQuery(criteriaDelete).executeUpdate();
		transaction.commit();

	}

}
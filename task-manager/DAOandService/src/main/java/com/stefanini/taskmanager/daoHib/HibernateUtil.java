package com.stefanini.taskmanager.daoHib;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final EntityManager entityManager = buildEntityManagerFactory().createEntityManager();
	static Logger logger = Logger.getLogger(HibernateUtil.class);

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			return new Configuration().configure().addAnnotatedClass(com.stefanini.taskmanager.domain.Task.class)
					.addAnnotatedClass(com.stefanini.taskmanager.domain.User.class).buildSessionFactory();
		} catch (Throwable ex) {

			logger.error("Initial SessionFactory creation failed. " + ex);

			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void shutdown() {
		entityManager.close();
	}
}

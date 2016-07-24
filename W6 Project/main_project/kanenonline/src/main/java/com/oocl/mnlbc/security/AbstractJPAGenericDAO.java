package com.oocl.mnlbc.security;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.oocl.mnlbc.dao.GenericDAO;

/**
 * Abstract DAO base class
 * 
 * @author BRIONSE
 *
 */
public abstract class AbstractJPAGenericDAO<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	private Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractJPAGenericDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		entityManager = entityManagerFactory.createEntityManager();

		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];

	}

	@Override
	public T findById(long id) {
		return (T) entityManager.find(type, id);
	}

	@Override
	public T update(final T t) {
		return this.entityManager.merge(t);
	}

}

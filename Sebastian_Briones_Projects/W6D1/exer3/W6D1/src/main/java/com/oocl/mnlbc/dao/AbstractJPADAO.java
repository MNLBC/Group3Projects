package com.oocl.mnlbc.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public abstract class AbstractJPADAO<T> implements GenericDAO<T> {

	@SuppressWarnings("rawtypes")
	private static EntityManager em = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap())
			.createEntityManager();

	protected Class<T> clazz;

	public T findById(Object id) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		return em.find(clazz, id);
	}

	public void persist(T entity) {
		em.persist(entity);
	}

	public void remove(T entity) {
		em.remove(entity);
	}

}

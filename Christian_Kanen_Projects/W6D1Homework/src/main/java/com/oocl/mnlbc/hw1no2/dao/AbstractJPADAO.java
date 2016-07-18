/**
 * 
 */
package com.oocl.mnlbc.hw1no2.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author KANENCH
 * @param <T>
 *
 */
public class AbstractJPADAO<T> implements GenericDAO<T> {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Class<T> clazz;

	public AbstractJPADAO() {
		init();
	}

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void create(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}


	public T getById(Long entityId) {
		return entityManager.find(clazz, entityId);
	}

	public void deleteById(long entityId) {
		T entity = getById(entityId);
		delete(entity);
	}

}

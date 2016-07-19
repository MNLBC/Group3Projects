package com.oocl.mnlbc.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAOService<T> implements GenericDAO<T> {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Class<T> clazz;
	

	public GenericDAOService() {
		init();
	}
	
	@SuppressWarnings("rawtypes")
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());
		clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public void create(T model) {
		entityManager.getTransaction().begin();
		entityManager.persist(model);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return (List<T>) entityManager.createNamedQuery("");
	}

	public void update(T model) {
		entityManager.getTransaction().begin();
		entityManager.merge(model);
		entityManager.getTransaction().commit();
	}

	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(getById(id));
		entityManager.getTransaction().commit();

	}

	public T getById(int id) {
		return entityManager.find(clazz, id);
	}

}

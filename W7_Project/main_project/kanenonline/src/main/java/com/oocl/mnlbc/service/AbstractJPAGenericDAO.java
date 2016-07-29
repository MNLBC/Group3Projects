package com.oocl.mnlbc.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.dao.GenericDAO;

/**
 * Abstract DAO base class
 * 
 * @author BRIONSE
 *
 */
public abstract class AbstractJPAGenericDAO<T> implements GenericDAO<T> {

	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractJPAGenericDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		entityManager = entityManagerFactory.createEntityManager();

		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];

	}

	public void create(T entity){
		entityManager.persist(entity);
	}
	
	public T findById(long id) {
		return (T) entityManager.find(type, id);
	}

	public T update(final T entity) {
		entityManager.getTransaction().begin();
		T updatedEntity = this.entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return updatedEntity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return entityManager.createQuery("SELECT u FROM " + type.getSimpleName() + " u").getResultList();
	}
	
	public void delete(long id){
		T entity = findById(id);
		entityManager.remove(entity);
	}

	
}

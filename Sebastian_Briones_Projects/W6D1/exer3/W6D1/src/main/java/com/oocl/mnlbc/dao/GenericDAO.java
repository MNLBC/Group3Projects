package com.oocl.mnlbc.dao;


public interface GenericDAO<T> {

	T findById(Object id);

	void persist(T entity);

	void remove(T entity);

}

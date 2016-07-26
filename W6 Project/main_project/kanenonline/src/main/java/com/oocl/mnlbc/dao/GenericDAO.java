package com.oocl.mnlbc.dao;

import java.util.List;

public interface GenericDAO<T> {

	void create(T entity);

	T findById(long id);

	T update(T entity);

	List<T> findAll();
	
	void delete(long id);
}

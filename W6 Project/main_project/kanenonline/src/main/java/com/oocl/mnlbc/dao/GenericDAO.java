package com.oocl.mnlbc.dao;

public interface GenericDAO<T> {

	T findById(long id);

	T update(T t);
}

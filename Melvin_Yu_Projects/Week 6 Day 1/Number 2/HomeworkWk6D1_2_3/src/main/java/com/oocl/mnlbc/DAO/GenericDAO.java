package com.oocl.mnlbc.DAO;

import java.util.List;

public interface GenericDAO<T> {
	
	abstract void create(T model);
	abstract List<T> getList();
	abstract void update(T model);
	abstract void delete(int id);
	abstract T getById(int id);
	
}

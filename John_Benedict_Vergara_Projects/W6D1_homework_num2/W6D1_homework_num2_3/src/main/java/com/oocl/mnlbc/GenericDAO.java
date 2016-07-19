package com.oocl.mnlbc;

import java.util.List;

public interface GenericDAO<GenericEntity> {
	public abstract List<GenericEntity> getAll();

	public abstract GenericEntity persist(GenericEntity entity);

	public abstract void delete(GenericEntity entity);
}
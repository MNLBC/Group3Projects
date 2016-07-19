/**
 * 
 */
package com.oocl.mnlbc.hw1no2.dao;

import java.util.List;

/**
 * @author KANENCH
 *
 */
public interface GenericDAO<T> {

	void create(T entity);

	List<T> findAll();

	void update (T entity);

	void delete(final T entity);

	void deleteById(final long entityId);

}

/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Items;

/**
 * @author VERGAJO
 *
 */
public class ItemService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public List<Items> getItem() {

		return entityManager.createQuery("SELECT I FROM ITEM I").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}

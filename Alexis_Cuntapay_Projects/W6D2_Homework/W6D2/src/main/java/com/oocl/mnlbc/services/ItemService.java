package com.oocl.mnlbc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.Item;
/**
 * 
 * @author CUNTAAL
 *
 */
public class ItemService {

	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        entityManager = entityManagerFactory.createEntityManager();

    }
    
    public List<Item> getItem(EntityManager em) {
    	return entityManager.createQuery("select i from Item i").getResultList();
}
}


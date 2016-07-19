package com.oocl.mnlbc.group3.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.group3.dao.ItemDAO;
import com.oocl.mnlbc.group3.model.Item;

/**
 * Item DAO Implementation Class
 * 
 * @author BRIONSE
 *
 */
public class ItemDAOImpl implements ItemDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager em;

	public ItemDAOImpl() {
		
	}

	public void init(){
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		em = entityManagerFactory.createEntityManager();
	}


	public Item getItemById(long itemId) {
		return (Item) em.find(Item.class, itemId);
	}

}

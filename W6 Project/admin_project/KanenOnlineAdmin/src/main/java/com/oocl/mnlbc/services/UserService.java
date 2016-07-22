package com.oocl.mnlbc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.User;

/**
 * 
 * @author Melvin Yu
 *
 */
public class UserService {
	  private EntityManagerFactory entityManagerFactory;
	    private EntityManager entityManager;

	    public void init() {
	        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
	        System.out.println(entityManagerFactory.getClass().getSimpleName());
	        entityManager = entityManagerFactory.createEntityManager();
	        System.out.println(entityManager.getClass().getSimpleName());

	    }


	    public  User getById(EntityManager em, Integer id) {
	    	User user = em.find(User.class, id);
	        return user;
	    }

	    public User update(EntityManager em, User user) {
	        em.getTransaction().begin();
	        em.merge(user);
	        em.getTransaction().commit();
	        return user;
	    }

	    public void remove(EntityManager em, User user) {
	        em.getTransaction().begin();
	        em.remove(user);
	        em.getTransaction().commit();
	    }
	    public List<User> getList() {
	        return entityManager.createQuery("select r from Teachers r").getResultList();
	    }

	    public EntityManager getEntityManager() {
	        return entityManager;
	    }
}

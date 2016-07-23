package com.oocl.mnlbc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.security.PasswordEncrypter.InvalidHashException;

/**
 * 
 * @author Melvin Yu
 *
 */
public class UserService implements UserDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.UserDAO#getList()
	 */
	public List<User> getList() {
		return entityManager.createQuery("select r from user r").getResultList();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.UserDAO#validateUser(java.lang.String,
	 * java.lang.String)
	 */
	public User validateUser(String username, String password) {

		Query query = entityManager.createQuery("select r from user r where r.username= :username");
		query.setParameter("username", username);
		User user;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

		String passwordHash = user.getUserPassword();

		try {
			if (PasswordEncrypter.verifyPassword(password, passwordHash)) {
				return user;
			}
		} catch (CannotPerformOperationException e) {
			e.printStackTrace();
		} catch (InvalidHashException e) {
			e.printStackTrace();
		}

		return null;

	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.UserDAO#findById(java.lang.String)
	 */
	public User findById(long id) {
	 	User user = entityManager.find(User.class, id);
        return user;
	}


}

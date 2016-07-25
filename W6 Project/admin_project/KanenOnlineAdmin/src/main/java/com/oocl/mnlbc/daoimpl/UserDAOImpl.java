package com.oocl.mnlbc.daoimpl;

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
 * this is the User DAO Implementation of the UserDAO
 */
public class UserDAOImpl implements UserDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	/**
	 * initialize the EntityManager & Factory
	 */
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	/**
	 * returns the instance of the EntityManager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @return List<User>
	 * this gets all the list of the users in the DB
	 */
	public List<User> getList() {
		return entityManager.createQuery("select r from user r").getResultList();
	}
	
	/**
	 * @param username password
	 * @return User
	 * This validates the login of the user
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

	/**
	 * @return User
	 * @param id
	 * this finds a user by user_id
	 */
	public User findById(long id) {
	 	User user = entityManager.find(User.class, id);
        return user;
	}


}

package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.security.PasswordEncrypter.InvalidHashException;

/**
 * User Service Class
 * 
 * @author John Benedict Vergara
 *
 */
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public UserDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Checks if a username is already in use.
	 */
	public boolean userExists(String username) {
		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.username= :username");
		query.setParameter("username", username);
		List<User> user = query.getResultList();

		return (!user.isEmpty());
		
	}

	/**
	 * Checks if the email address is already in use.
	 */
	public boolean emailExists(String email) {
		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.email= :email");
		query.setParameter("email", email);
		List<User> user = query.getResultList();

		return (!user.isEmpty());

	}

	/**
	 * Validates  a user's login credentials
	 */
	public User validateAccount(String username, String password) {
		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.username= :username");
		query.setParameter("username", username);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}

		if (user != null) {

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
		return null;

	}

	/**
	 * Registers/creates a new user account.
	 */
	@Override
	public boolean registerUser(User user) {
		String userPassword = user.getUserPassword();

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(userPassword);
		} catch (CannotPerformOperationException e1) {
			e1.printStackTrace();
		}
		try {
			user.setUserPassword(enryptedPassword);
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public List<User> getBannedUsers() {

		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.isBlacklisted='YES'");
		List<User> user = query.getResultList();
		return user;
	}

}

package com.oocl.mnlbc.daoimpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.oocl.mnlbc.constants.KanenOnlineConstants;
import com.oocl.mnlbc.dao.UserDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;
import com.oocl.mnlbc.security.PasswordEncrypter;
import com.oocl.mnlbc.security.PasswordEncrypter.CannotPerformOperationException;
import com.oocl.mnlbc.security.PasswordEncrypter.InvalidHashException;

/**
 * 
 * @author VERGAJO
 *
 */
public class UserDAOImpl extends AbstractJPAGenericDAO<User> implements UserDAO {

	public UserDAOImpl() {
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
	 * Validates a user's login credentials
	 */
	public User validateAccount(String username, String password) {
		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.username= :username");
		query.setParameter("username", username);
		User user = null;
		try {
			user = (User) query.getSingleResult();
			entityManager.refresh(user);
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
			entityManager.getTransaction().begin();
			User newlyCreatedUser = this.findUserByUsername(user.getUsername());

			UserMembershipAsn userMembershipAsn = new UserMembershipAsn();
			userMembershipAsn.setUserId(newlyCreatedUser);

			// set the default membership type to member
			userMembershipAsn.setMembershipTypeId(KanenOnlineConstants.DEFAULT_USER_MEMBERSHIP_TYPE);
			
			entityManager.persist(userMembershipAsn);
			entityManager.getTransaction().commit();
			

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Returns the list of banned users
	 */
	@Override
	public List<User> getBannedUsers() {

		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.isBlacklisted='YES'");
		List<User> user = query.getResultList();
		return user;
	}

	/**
	 * Finds a user by username
	 * 
	 * @param username
	 * @return User
	 */
	public User findUserByUsername(String username) {
		Query query = entityManager.createQuery("SELECT U FROM User U WHERE U.username= :username");
		query.setParameter("username", username);
		User user = null;
		try {
			user = (User) query.getSingleResult();
			entityManager.refresh(user);
		} catch (NoResultException e) {
			user = null;
		}

		return user;
	}

	/**
	 * Updates the users encrypted password
	 */
	public boolean changePassword(User user, String newPassword) {

		String enryptedPassword = "";
		try {
			enryptedPassword = PasswordEncrypter.createHash(newPassword);
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

	public boolean updateUser(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}

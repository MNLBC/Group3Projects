package com.oocl.mnlbc.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.UserMembershipAsnDAO;
import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.UserMembershipAsn;

/**
 * 
 * @author Melvin Yu
 *
 */
public class UserMembershipAsnDAOImpl implements UserMembershipAsnDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	/**
	 * initialize the EntityManager & Factory
	 */
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();

	}
	/**
	 * returns the instance of the EntityManager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param asn
	 * @return UserMembershipAsn
	 * 
	 * updates the membershipasn table if it is approved or disapproved
	 */
	public UserMembershipAsn updateMembership(UserMembershipAsn asn) {

		entityManager.getTransaction().begin();
		UserMembershipAsn newAsn = entityManager.merge(asn);
		entityManager.getTransaction().commit();

		return newAsn;
	}

	/**
	 * @param userId
	 * @return UserMembershipAsn
	 * 
	 * this gets a UserMembershipAsn by userId
	 */
	public UserMembershipAsn findMembership(User userId) {
		  Query query = entityManager.createQuery("select r from userMemAssn r where r.userId = :userId");
			query.setParameter("userId", userId);
			UserMembershipAsn result = (UserMembershipAsn) query.getSingleResult();
			return result;
	  }

	/**
	 * @return List<UserMembershipAsn>
	 * this gets all the membership request. where forApproval = 1
	 */
	public List<UserMembershipAsn> allMembershipRequest() {
		 Query query = entityManager.createQuery("select r from userMemAssn r where r.forApproval = :request ");
		 query.setParameter("request", 1);
			List<UserMembershipAsn> result =  query.getResultList();
			return result;
	}

}

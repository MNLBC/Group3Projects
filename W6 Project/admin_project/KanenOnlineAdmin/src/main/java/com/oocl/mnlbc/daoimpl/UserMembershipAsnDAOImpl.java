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
	 * @see com.oocl.mnlbc.dao.UserMembershipAsnDAO#updateMembership(long)
	 */
	public UserMembershipAsn updateMembership(UserMembershipAsn asn) {

		entityManager.getTransaction().begin();
		UserMembershipAsn newAsn = entityManager.merge(asn);
		entityManager.getTransaction().commit();

		return newAsn;
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.UserMembershipAsnDAO#findMembership(long)
	 */
	public UserMembershipAsn findMembership(User userId) {
		  Query query = entityManager.createQuery("select r from userMemAssn r where r.userId = :userId");
			query.setParameter("userId", userId);
			UserMembershipAsn result = (UserMembershipAsn) query.getSingleResult();
			return result;
	  }

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.UserMembershipAsnDAO#allMembershipRequest()
	 */
	public List<UserMembershipAsn> allMembershipRequest() {
		 Query query = entityManager.createQuery("select r from userMemAssn r where r.forApproval = :request ");
		 query.setParameter("request", 1);
			List<UserMembershipAsn> result =  query.getResultList();
			return result;
	}

}

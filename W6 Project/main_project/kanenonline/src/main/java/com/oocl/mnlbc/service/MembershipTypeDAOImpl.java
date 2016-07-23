package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.MembershipTypeDAO;

/**
 * 
 * @author Melvin Yu
 *
 */
public class MembershipTypeDAOImpl implements MembershipTypeDAO {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@SuppressWarnings("rawtypes")
	public MembershipTypeDAOImpl() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		entityManager = entityManagerFactory.createEntityManager();

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oocl.mnlbc.dao.MembershipTypeDAO#getType(long)
	 */
	public long getIdByTypeName(String typeName) {
		Query query = entityManager
				.createQuery("select r.membershipTypeId from memberType r where r.membershipTypeName = :typename");
		query.setParameter("typename", typeName);
		long result = (Long) query.getSingleResult();
		return result;
	}

	public String getMembershipTypeNameById(long typeId) {
		Query query = entityManager
				.createQuery("select r.membershipTypeName from memberType r where r.membershipTypeId = :typeid");
		query.setParameter("typeid", typeId);
		String membershipTypeName = (String) query.getSingleResult();
		return membershipTypeName;

	}

}

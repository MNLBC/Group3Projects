package com.oocl.mnlbc.daoimpl;

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

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/* (non-Javadoc)
	 * @see com.oocl.mnlbc.dao.MembershipTypeDAO#getType(long)
	 */
	public long getIdByTypeName(String typeName) {
		Query query = entityManager.createQuery("select r.membershipTypeId from memberType r where r.membershipTypeName = :typename");
		query.setParameter("typename", typeName);
		try{
		long result = (Long) query.getSingleResult();
		return result;
		}catch(Exception e){
			return 0;
		}
		
	}
	
	public String getNameById(long typeId) {
		Query query = entityManager.createQuery("select r.membershipTypeName from memberType r where r.membershipTypeId = :id");
		query.setParameter("id", typeId);
		try{
		String result = (String) query.getSingleResult();
		return result;
		}
		catch(Exception e){
			return null;
		}
	}
}

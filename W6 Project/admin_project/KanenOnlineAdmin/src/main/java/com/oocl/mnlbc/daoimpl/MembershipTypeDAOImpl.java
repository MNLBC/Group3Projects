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
 *This is the DAO Implementation of MembershipTypeDAO
 *this manage the retrieval of membershipTypeId by typename and vice versa
 */
public class MembershipTypeDAOImpl implements MembershipTypeDAO {
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
 * returns the intance of a entityManager
 * @return EntityManager
 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	/**
	 * @param typeName
	 * @return long
	 * this gets the id of the given membership type name
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
	/**
	 * 
	 * @param typeId
	 * @return String
	 * this gets the membership type name of the given id of the membershiptype 
	 */
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

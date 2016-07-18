package com.oocl.mnlbc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 * 
 * @author CUNTAAL
 *
 */
public class TeacherService {

	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        entityManager = entityManagerFactory.createEntityManager();

    }
    
    public void getTeacherAverage(EntityManager em) {
    	Query query = em.createNativeQuery("SELECT B.TEACHER_NAME, B.TEACHER_SHOOL_NAME, AVG(A.STUDENT_SCORE) "
    			+ "FROM A_STUDENT A, A_TEACHER B WHERE A.STUDENT_TEACHER_ID = B.TEACHER_ID GROUP BY B.TEACHER_NAME, B.TEACHER_SHOOL_NAME");
    	List<Object[]> result = query.getResultList();
    	System.out.println("\nTeacher Name \t School Name \tAverage");
    	for(Object[] id : result){
    		System.out.println(id[0] + "\t\t" + id[1] + "\t\t" + id[2]);
    	}
    }
}

package com.oocl.mnlbc.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.jpa.entity.Teacher;

public class TeacherService {
	  private EntityManagerFactory entityManagerFactory;
	    private EntityManager entityManager;

	    public void init() {
	        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
	        System.out.println(entityManagerFactory.getClass().getSimpleName());
	        entityManager = entityManagerFactory.createEntityManager();
	        System.out.println(entityManager.getClass().getSimpleName());

	    }

	    
	    public List<Teacher> getTeacherList() {
	        return entityManager.createQuery("select t from Teacher t").getResultList();
	    }
	    
	    public List<Object[]> getListandAvg(){
	    	return entityManager.createNativeQuery("SELECT t.teacher_name, t.teacher_school_name, AVG(student_score) FROM Teachers t, Students s WHERE t.teacher_id = s.teacher_id GROUP BY t.TEACHER_NAME, t.TEACHER_SCHOOL_NAME").getResultList();
	    }

	    public EntityManager getEntityManager() {
	        return entityManager;
	    }
	}
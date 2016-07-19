package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Teachers;

public class SchoolService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public List<Object[]> getTeachers() {
		return entityManager
				.createNativeQuery(
						"SELECT t.TEACHER_NAME, t.TEACHER_SCHOOL_NAME, AVG(STUDENT_SCORE) FROM TEACHERS t, STUDENTS s WHERE t.TEACHER_ID = s.TEACHER_ID GROUP BY t.TEACHER_NAME, t.TEACHER_SCHOOL_NAME")
				.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}

package com.oocl.mnlbc.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Student;
import com.oocl.mnlbc.entity.Teacher;

public class TestMain {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink",
				new java.util.HashMap());
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Teacher kolby = entityManager.find(Teacher.class, 1000000001L);
	
		
		List<Student> students = kolby.getStudents();
		System.out.println(kolby.getName());
		System.out.println(kolby.getSchool_name());
		int totalScore = 0;

		for (Student student : students) {
			totalScore += student.getStudentScore();
			System.out.println(student.getStudentName());
		}
		if (students.size() > 0) {
			System.out.println(totalScore / students.size());
		}

		entityManager.getTransaction().commit();

	}

}

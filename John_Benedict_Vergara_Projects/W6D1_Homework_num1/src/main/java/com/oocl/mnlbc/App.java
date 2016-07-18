package com.oocl.mnlbc;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Teachers;
import com.oocl.mnlbc.service.SchoolService;

public class App {

	public static void main(String[] args) {

		SchoolService schoolService = new SchoolService();
		schoolService.init();
		EntityManager em = schoolService.getEntityManager();

		List<Object[]> teachersList = schoolService.getTeachers();
		for (Object[] teacher : teachersList) {
			System.out.println("Teacher Name: " + teacher[0] + "School Name: " + teacher[1]
					+ " Student's Average Score: " + teacher[2]);
		}
	}
}

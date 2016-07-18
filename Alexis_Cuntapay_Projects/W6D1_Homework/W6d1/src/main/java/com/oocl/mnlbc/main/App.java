package com.oocl.mnlbc.main;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.services.TeacherService;

public class App {

	public static void main(String[] args){
		TeacherService ems = new TeacherService();
		ems.init();
		EntityManager em = ems.getEntityManager();
		System.out.println("===========================================");
		ems.getTeacherAverage(em);
		System.out.println("===========================================");
		em.close();
	}
}

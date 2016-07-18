package com.oocl.mnlbc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.plaf.synth.Region;

import com.oocl.mnlbc.jpa.entity.Teacher;
import com.oocl.mnlbc.jpa.service.TeacherService;

public class App {

public static void main(String[] args) {
		
		TeacherService ts = new TeacherService();
		ts.init();
		EntityManager em = ts.getEntityManager();
		
		ts.getTeacherList();
		List<Object[]> tlist= ts.getListandAvg();
		System.out.println("TEACHER_NAME \t \t TEACHER_SCHOOL_NAME \t \tSCORE AVERAGE");
		for(Object[] t: tlist){
			System.out.println(t[0] + "\t \t"+ t[1] + " \t \t "+ t[2]);
		}
	}
}

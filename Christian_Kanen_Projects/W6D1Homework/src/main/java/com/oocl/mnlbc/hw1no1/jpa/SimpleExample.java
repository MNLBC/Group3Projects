package com.oocl.mnlbc.hw1no1.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.hw1no1.entity.Students;
import com.oocl.mnlbc.hw1no1.entity.Teachers;
import com.oocl.mnlbc.hw1no1.service.TeacherService;

public class SimpleExample {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        teacherService.init();
        EntityManager em = teacherService.getEntityManager();

        selectTeacher(teacherService);

 /*       Teachers teacher = new Teachers("1001","Teacher Kolby","OOCL ITA");

        String id = teacherService.createTeacherInfo(em, teacher);

        selectTeacher(teacherService);*/


//        rs.removeRegion(em, fromDb);
//        System.out.println("fromDb deleted");
//        selectRegions(em);

        em.close();
    }

    
    
    private static void selectTeacher(TeacherService ts) {
		List<Teachers> result = ts.getTeacherList();
		System.out.println("=============================");
        for(Teachers r : result) {
        	int totalScore = 0;
            System.out.println("Teacher Name: "+ r.getTeacherName());
            System.out.println("Teacher School Name: " + r.getTeacherSchoolName());
            for (Students student: r.getStudentList()){
            	totalScore +=student.getStudentScore();
            }
            System.out.println("Average: " + (totalScore/r.getStudentList().size()));
        }
        System.out.println("=============================");
    }

}

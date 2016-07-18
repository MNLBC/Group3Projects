package com.oocl.mnlbc.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.oocl.mnlbc.entity.Student;
import com.oocl.mnlbc.entity.Teachers;
import com.oocl.mnlbc.service.TeacherService;

public class HomeworkTeacher {

    public static void main(String[] args) {
        TeacherService rs = new TeacherService();
        rs.init();
        EntityManager em = rs.getEntityManager();

//        selectTeachers(em);
        List<Student> studentList = new ArrayList<Student>();
       
        Teachers teacher = new Teachers("100","SAM","ITA");
        studentList.add(new Student("101","Melvin",100,teacher));
        studentList.add(new Student("102","Baste",87,teacher));
        studentList.add(new Student("103","Ziggy",90,teacher));
        teacher.setStudentList(studentList);
       
        String id = rs.createTeacher(em, teacher);
        
        Teachers teacherDb= rs.getTeacher(em, id);
        
       
        selectTeachers(em, id,teacherDb);
        
        rs.removeTeacher(em,teacherDb);
        
        
        

        em.close();
    }

    private static void selectTeachers(EntityManager em, String id,Teachers teacher) {
    	System.out.println("The Teacher:");
        Query query = em.createQuery("select t from teacher t where t.teacherId= :id");
        query.setParameter("id", id);
        List<Teachers> teacherResult =query.getResultList();
      System.out.println(teacherResult);
      System.out.println("=============================");
      System.out.println("His/Her Students:");
       query = em.createQuery("select t from student t where t.teacherId= :teacher");
      query.setParameter("teacher", teacher);
      List<Teachers> studentResult =query.getResultList();
      System.out.println(studentResult);
        System.out.println("=============================");
    }

}

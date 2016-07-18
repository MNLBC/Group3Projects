package com.oocl.mnlbc.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Teachers;

public class TeacherService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }

    public  String createTeacher(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        return teacher.getTeacherId();
    }

    public  Teachers getTeacher(EntityManager em, String id) {
        Teachers teacher = em.find(Teachers.class, id);
        return teacher;
    }

    public Teachers updateTeacher(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        return teacher;
    }

    public void removeTeacher(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
    }
    public List<Teachers> getTeacherList() {
        return entityManager.createQuery("select r from Teachers r").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

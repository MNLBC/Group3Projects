package com.oocl.mnlbc.hw1no1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.hw1no1.entity.Teachers;

public class TeacherService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }

    public  String createTeacherInfo(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        return teacher.getTeacherId();
    }

    public  Teachers getRegion(EntityManager em, Integer id) {
        Teachers region = em.find(Teachers.class, id);
        return region;
    }

    public Teachers updateRegion(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        return teacher;
    }

    public void removeRegion(EntityManager em, Teachers teacher) {
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
    }
    public List<Teachers> getTeacherList() {
        return entityManager.createQuery("select t from Teachers t").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.oocl.mnlbc.entity.User;

public class UserService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }

    public  Integer createUser(EntityManager em, User teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        return teacher.getUserId();
    }

    public  User getUser(EntityManager em, Integer id) {
        User teacher = em.find(User.class, id);
        return teacher;
    }

    public void removeUser(EntityManager em, User teacher) {
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

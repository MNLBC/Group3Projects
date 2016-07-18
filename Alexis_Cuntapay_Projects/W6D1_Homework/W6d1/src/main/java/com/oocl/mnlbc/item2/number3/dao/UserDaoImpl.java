package com.oocl.mnlbc.item2.number3.dao;

import java.util.List;

import javax.persistence.Query;

import com.oocl.mnlbc.item2.number3.entity.User;

@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> {

    public User loadUserByUsername(String username) {
        Query query = this.em.createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
}
package com.oocl.mnlbc.item2.number3.interfaces;

import com.oocl.mnlbc.item2.number3.entity.User;

public interface UserDao extends GenericDao<User> {
	   
    public User loadUserByUsername(String username);
}
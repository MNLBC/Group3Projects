package com.oocl.mnlbc.item2.number3.interfaces;
import java.util.Map;

public interface GenericDao<T> {
    
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);   
}
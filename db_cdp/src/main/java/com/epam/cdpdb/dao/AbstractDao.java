package com.epam.cdpdb.dao;

import com.epam.cdpdb.entities.Entity;

import java.util.List;

/**
 * @author Savostytskyi Anton on 07.10.2015.
 */
public abstract class AbstractDao<K,T extends Entity>{
    public abstract List<T> findAll();
    public abstract T findEntityById(K Id);
    public abstract boolean delete(T entity);
    public abstract boolean create(T entity);
    public abstract T update(T entity);
}

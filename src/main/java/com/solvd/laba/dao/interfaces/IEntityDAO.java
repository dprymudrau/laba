package com.solvd.laba.dao.interfaces;

public interface IEntityDAO<T>{
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
}


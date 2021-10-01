package com.solvd.laba.dao.interfaces;

public interface IEntityDAO<T>{
    public void save(T t);
    public void delete(T t);
    public void update(T t);
    T getById(long id);
}


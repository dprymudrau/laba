package com.solvd.laba.dao.jdbc;

public interface IEntityDAO<T> {

    void save(T t);
    void delete(T t);
    T getById(long id);
}
package com.solvd.laba.dao.interfaces;

public interface IEntityDAO <T> {
    void select(T entity);
    void save(T entity);
    void delete(T entity);
    void update(T entity);
}

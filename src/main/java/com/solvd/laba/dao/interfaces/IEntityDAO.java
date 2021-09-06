package com.solvd.laba.dao.interfaces;

public interface IEntityDAO <T> {
    public void save(T entity);
    public void delete(T entity);
}

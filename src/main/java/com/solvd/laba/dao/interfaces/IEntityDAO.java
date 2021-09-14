package com.solvd.laba.dao.interfaces;

import java.sql.SQLException;

public interface IEntityDAO <T> {
    void select(String fooSQL, String barSQL) throws SQLException, InterruptedException;
    void save(T entity);
    void delete(T entity);
    void update(T entity);
}

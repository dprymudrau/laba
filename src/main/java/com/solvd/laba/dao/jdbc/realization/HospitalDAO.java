package com.solvd.laba.dao.jdbc.realization;

import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.dao.interfaces.IEntityDAO;
import com.solvd.laba.pojo.Hospital;
import com.solvd.laba.example.connections.Connection;

import java.sql.SQLException;

public class HospitalDAO extends AbstractDAO implements IEntityDAO<Hospital> {

    @Override
    public void select(Hospital entity) {

    }

    @Override
    public void save(Hospital entity) {

    }

    @Override
    public void delete(Hospital entity) {

    }

    @Override
    public void update(Hospital entity) {

    }

    @Override
    public Connection getConnection() throws SQLException {
        return (Connection) connections.retrieve();
    }

    @Override
    public void releaseConnection(Connection connection) {

    }
}

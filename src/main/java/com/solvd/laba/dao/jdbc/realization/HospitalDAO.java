package com.solvd.laba.dao.jdbc.realization;

import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.dao.interfaces.IHospitalDAO;
import com.solvd.laba.pojo.Hospital;
import com.solvd.laba.threads.connections.Connection;

public class HospitalDAO extends AbstractDAO implements IHospitalDAO {

    @Override
    public void save(Hospital entity) {

    }

    @Override
    public void delete(Hospital entity) {

    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {

    }
}

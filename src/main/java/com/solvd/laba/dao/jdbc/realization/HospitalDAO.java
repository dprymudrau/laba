package com.solvd.laba.dao.jdbc.realization;

import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.dao.interfaces.IEntityDAO;
import com.solvd.laba.pojo.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalDAO extends AbstractDAO implements IEntityDAO<Hospital> {
    private Statement stmt = null;
    private ResultSet rs = null;

    private static final Logger LOGGER = LogManager.getLogger(HospitalDAO.class);

    public HospitalDAO() {
        try {
            stmt = connections.retrieve().createStatement();
        } catch (SQLException | InterruptedException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void select(String fooSQL, String barSQL) throws SQLException {
        rs = stmt.executeQuery("SELECT " + fooSQL + " FROM " + barSQL);
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
    public Connection getConnection() {
        Connection conn = null;
        try {
           conn = connections.retrieve();
        } catch (SQLException | InterruptedException e) {
            LOGGER.error(e);
        }
        return conn;
    }

    @Override
    public void releaseConnection(Connection connection) {

    }
}

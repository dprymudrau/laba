package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.binary.Emploee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmploeeDAOImpl extends AbstractDAO implements EmploeeDAO {

    private static final Logger LOGGER = LogManager.getLogger(EmploeeDAOImpl.class);
    private final static String MY_QUERY = "SELECT * FROM Emploee WHERE id = ?";


    @Override
    public void save(Emploee emploee) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");

    }

    @Override
    public void delete(Emploee emploee) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");

    }

    @Override
    public Emploee getById(Long id) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Emploee emploee = new Emploee();
        try (PreparedStatement preparedStatement = connection.prepareStatement(MY_QUERY)){
            LOGGER.debug("preparedStatement" + preparedStatement +" created.");
            preparedStatement.setLong(1, id.longValue());
            LOGGER.debug("Query" + MY_QUERY + "started");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                emploee.setcCName(resultSet.getString("cCName"));
            }
            LOGGER.info("Employee was retrieved from db" + emploee);
            return emploee;
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            closeResourse(resultSet);
            returnConnection(connection);
        }
    }
}

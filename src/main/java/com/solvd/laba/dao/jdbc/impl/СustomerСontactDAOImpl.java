package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.СustomerСontact;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfases.СustomerСontactDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class СustomerСontactDAOImpl extends AbstractDAO implements СustomerСontactDAO {
    private static final Logger LOGGER = LogManager.getLogger(СustomerСontactDAOImpl.class);
    private final static String MY_QUERY = "SELECT * FROM СustomerСontact WHERE id = ?";
    private int emailsID;

    @Override
    public void save(СustomerСontact сustomerСontact) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void delete(СustomerСontact сustomerСontact) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public СustomerСontact getById(Long id) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        СustomerСontact сustomerСontact = new СustomerСontact();
        try (PreparedStatement preparedStatement = connection.prepareStatement(MY_QUERY)) {
            LOGGER.debug("preparedStatement" + preparedStatement + " created.");
            preparedStatement.setLong(1, id.longValue());
            LOGGER.debug("Query" + MY_QUERY + "started");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                сustomerСontact.setcCName(resultSet.getString("cCName"));
            }
            LOGGER.info("СustomerСontact was retrieved from db" + сustomerСontact);
            return сustomerСontact;
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            closeResourse(resultSet);
            returnConnection(connection);
        }
    }

    public void setEmailsID(int emailsID) {
        this.emailsID = emailsID;
    }
}

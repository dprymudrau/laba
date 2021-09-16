package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.ITCompanyContact;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfases.ITCompanyContactDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ITCompanyContactDAOImpl extends AbstractDAO implements ITCompanyContactDAO {
    private static final Logger LOGGER = LogManager.getLogger(ITCompanyContactDAOImpl.class);

    private final static String MY_QUERY = "SELECT * FROM ITCompanyContact WHERE id = ?";

    @Override
    public void save(ITCompanyContact itCompanyContact) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void delete(ITCompanyContact itCompanyContact) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public ITCompanyContact getById(Long id) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        ITCompanyContact iTCompanyContact = new ITCompanyContact();
        try (PreparedStatement preparedStatement = connection.prepareStatement(MY_QUERY)){
            LOGGER.debug("preparedStatement" + preparedStatement +" created.");
            preparedStatement.setLong(1, id.longValue());
            LOGGER.debug("Query" + MY_QUERY + "started");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                iTCompanyContact.setiTCCName(resultSet.getString("iTCCName"));
            }
            LOGGER.info("iTCompanyContact was retrieved from db" + iTCompanyContact);
            return iTCompanyContact;
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            closeResourse(resultSet);
            returnConnection(connection);
        }
    }
}

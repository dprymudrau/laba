package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.FlightCategory;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.FlightCategoryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightCategoryDaoImpl extends AbstractDAO implements FlightCategoryDAO {

    private static Logger LOGGER = LogManager.getLogger(FlightCategoryDaoImpl.class);

    private static String GET_FLIGHT_CATEGORY_BY_ID_Q = "SELECT idFlightCategory, " +
            "flightCategoryName " +
            "FROM FlightCategory " +
            "WHERE idFlightCategory = ?";

    @Override
    public void save(FlightCategory flightCategory) {

    }

    @Override
    public void delete(FlightCategory flightCategory) {

    }

    @Override
    public FlightCategory getById(long id) {
        FlightCategory flightCategory = new FlightCategory();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_FLIGHT_CATEGORY_BY_ID_Q);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    flightCategory.setIdFlightCategory(rs.getLong("idFlightCategory"));
                    flightCategory.setFlightCategoryName(rs.getString("flightCategoryName"));
                }
                else{
                    return null;
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flightCategory;
    }
}

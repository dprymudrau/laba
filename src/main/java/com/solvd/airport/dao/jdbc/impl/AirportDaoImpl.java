package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.Airport;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.AirportDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportDaoImpl extends AbstractDAO implements AirportDAO {

    private static Logger LOGGER = LogManager.getLogger(AirportDaoImpl.class);

    private static String GET_AIRPORT_BY_ID_Q = "SELECT idAirport, " +
            "townId, " +
            "airportName, " +
            "passengersPerDay " +
            "FROM Airport " +
            "WHERE idAirport = ?";

    @Override
    public void save(Airport airport) {


    }

    @Override
    public void delete(Airport airport) {

    }

    @Override
    public Airport getById(long id) {
        Airport airport = new Airport();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_AIRPORT_BY_ID_Q);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    airport.setIdAirport(rs.getLong("idAirport"));
                    airport.setAirportName(rs.getString("airportName"));
                    airport.setTownId(rs.getLong("townId"));
                    airport.setPassengersPerDay(rs.getInt("passengersPerDay"));
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
        return airport;
    }
}

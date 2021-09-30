package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.Flight;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.FlightDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightDaoImpl extends AbstractDAO implements FlightDAO {
    private static Logger LOGGER = LogManager.getLogger(FlightDaoImpl.class);

    private static final String GET_FLIGHT_BY_WAY_Q =
            "SELECT idFlight, " +
                    "planeId, " +
                    "fromAirportId, " +
                    "whereAirportId, " +
                    "categoryId, " +
                    "price, " +
                    "flightDate " +
                    "FROM Flight " +
                    "WHERE fromAirportId = ? AND whereAirportId = ?";
    private static final String GET_FLIGHT_BY_WAY_AND_CATEGORY_Q =
            "SELECT idFlight, " +
                    "planeId, " +
                    "fromAirportId, " +
                    "whereAirportId, " +
                    "categoryId, " +
                    "price, " +
                    "flightDate " +
                    "FROM Flight " +
                    "LEFT JOIN FlightCategory ON categoryId=idFlightCategory " +
                    "WHERE fromAirportId = ? AND whereAirportId = ? AND flightCategoryName = ?";


    @Override
    public void save(Flight flight) {

    }

    @Override
    public void delete(Flight flight) {

    }

    @Override
    public Flight getById(long id) {
        return null;
    }

    public ArrayList<Flight> getByWay(long from, long where){
        ArrayList<Flight> result = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_FLIGHT_BY_WAY_Q);
                ps.setLong(1, from);
                ps.setLong(2, where);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Flight flight = new Flight();
                    flight.setIdFlight(rs.getLong("idFlight"));
                    flight.setPlaneId(rs.getLong("planeId"));
                    flight.setFromAirportId(from);
                    flight.setWhereAirportId(where);
                    flight.setCategoryId(rs.getLong("categoryId"));
                    flight.setPrice(rs.getInt("price"));
                    flight.setFlightDate(rs.getDate("flightDate"));
                    result.add(flight);
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Flight> getByWay(long from, long where, String category){
        ArrayList<Flight> result = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_FLIGHT_BY_WAY_AND_CATEGORY_Q);
                ps.setLong(1, from);
                ps.setLong(2, where);
                ps.setString(3, category);
                rs = ps.executeQuery();
                while(rs.next()) {
                    Flight flight = new Flight();
                    flight.setIdFlight(rs.getLong("idFlight"));
                    flight.setPlaneId(rs.getLong("planeId"));
                    flight.setFromAirportId(from);
                    flight.setWhereAirportId(where);
                    flight.setCategoryId(rs.getLong("categoryId"));
                    flight.setPrice(rs.getInt("price"));
                    flight.setFlightDate(rs.getDate("flightDate"));
                    result.add(flight);
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

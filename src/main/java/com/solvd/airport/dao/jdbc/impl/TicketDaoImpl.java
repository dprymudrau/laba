package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.Ticket;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.TicketDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDaoImpl extends AbstractDAO implements TicketDAO {

    private static Logger LOGGER = LogManager.getLogger(FlightCategoryDaoImpl.class);

    private static String PUT_TICKET_Q = "INSERT INTO Ticket (passengerId, flightId, placeNumber, dateOfBuying) " +
                                         "VALUES (?, ?, ?, ?)";


    @Override
    public void save(Ticket ticket) {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                ps = connection.prepareStatement(PUT_TICKET_Q);
                ps.setLong(1, ticket.getPassengerId());
                ps.setLong(2, ticket.getFlightId());
                ps.setInt(3, ticket.getPlaceNumber());
                ps.setDate(4, ticket.getDateOfBuying());
                ps.executeUpdate();
            }
            catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
            finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) {

    }

    @Override
    public Ticket getById(long id) {
        return null;
    }
}

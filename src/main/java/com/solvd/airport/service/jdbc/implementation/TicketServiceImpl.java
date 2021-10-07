package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.Ticket;
import com.solvd.airport.dao.jdbc.impl.TicketDaoImpl;
import com.solvd.airport.service.interfaces.TicketService;

public class TicketServiceImpl implements TicketService {

    @Override
    public void putTicketToDB(Ticket ticket) {
        TicketDaoImpl ticketDao = new TicketDaoImpl();
        ticketDao.save(ticket);
    }
}

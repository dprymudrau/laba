package com.solvd.airport.service.interfaces;

import com.solvd.airport.binary.Ticket;

import java.util.HashMap;

public interface TicketService {

    HashMap<Integer, Ticket> getTicketsHashMap();

    void putTicketToDB(Ticket ticket);

}

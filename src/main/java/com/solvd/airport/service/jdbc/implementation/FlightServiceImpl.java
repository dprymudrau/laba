package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.Flight;
import com.solvd.airport.dao.jdbc.impl.FlightDaoImpl;
import com.solvd.airport.service.interfaces.FlightService;

import java.util.ArrayList;

public class FlightServiceImpl implements FlightService {

    public ArrayList<Flight> getFlightsByWay(long from, long where){
        FlightDaoImpl flightDao = new FlightDaoImpl();
        return flightDao.getByWay(from, where);
    }

    public ArrayList<Flight> getFlightsByWay(long from, long where, String category){
        FlightDaoImpl flightDao = new FlightDaoImpl();
        return flightDao.getByWay(from, where, category);
    }
}

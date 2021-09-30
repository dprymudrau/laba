package com.solvd.airport.service.interfaces;

import com.solvd.airport.binary.Flight;

import java.util.ArrayList;

public interface FlightService {

    ArrayList<Flight> getFlightsByWay(long from, long where);
    ArrayList<Flight> getFlightsByWay(long from, long where, String category);


    }

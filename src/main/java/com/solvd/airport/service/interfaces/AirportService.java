package com.solvd.airport.service.interfaces;

import com.solvd.airport.binary.Airport;

import java.util.HashMap;

public interface AirportService {

    HashMap<Long, Airport> getAirportsHashMap();

}

package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.Airport;
import com.solvd.airport.dao.jdbc.impl.AirportDaoImpl;
import com.solvd.airport.service.interfaces.AirportService;

import java.util.HashMap;

public class AirportServiceImpl implements AirportService {

    @Override
    public HashMap<Long, Airport> getAirportsHashMap() {
        HashMap<Long, Airport> result = new HashMap<>();
        Airport airport;
        long id = 1;
        while (true){
            AirportDaoImpl airportDao = new AirportDaoImpl();
            airport = airportDao.getById(id);
            id++;
            if(airport!=null){
                result.put(airport.getIdAirport(), airport);
            }
            else break;
        }
        return result;
    }
}

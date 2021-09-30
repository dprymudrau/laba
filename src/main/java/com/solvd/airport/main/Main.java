package com.solvd.airport.main;

import com.solvd.airport.service.jdbc.implementation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[]args){
        AirportServiceImpl airportService = new AirportServiceImpl();
        LOGGER.info(airportService.getAirportsHashMap());
        FlightCategoryServiceImpl flightCategoryService = new FlightCategoryServiceImpl();
        LOGGER.info(flightCategoryService.getFlightCategoriesHashMap());
        FlightServiceImpl flightService = new FlightServiceImpl();
        LOGGER.info(flightService.getFlightsByWay(1,2));
        LOGGER.info(flightService.getFlightsByWay(2,3,"VIP"));
        PlaneServiceImpl planeService = new PlaneServiceImpl();
        LOGGER.info(planeService.getPlaneById(1));
        PlaneModelServiceImpl planeModelService = new PlaneModelServiceImpl();
        LOGGER.info(planeModelService.getPlaneModelById(1));
    }
}

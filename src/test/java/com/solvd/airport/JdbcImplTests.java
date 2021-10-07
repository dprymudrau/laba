package com.solvd.airport;

import com.solvd.airport.binary.*;
import com.solvd.airport.service.jdbc.implementation.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;

public class JdbcImplTests {

    @Test
    public void airportServiceTest(){
        AirportServiceImpl airportService = new AirportServiceImpl();
        HashMap<Long, Airport> airportHashMap = airportService.getAirportsHashMap();
        Assert.assertEquals(airportHashMap.size(), 3);
    }

    @Test
    public void flightCategoryServiceTest(){
        FlightCategoryServiceImpl flightCategoryService = new FlightCategoryServiceImpl();
        HashMap<Long, FlightCategory> flightCategoryHashMap = flightCategoryService.getFlightCategoriesHashMap();
        Assert.assertEquals(flightCategoryHashMap.size(), 3);
    }

    @Test
    public void flightServiceTest(){
        FlightServiceImpl flightService = new FlightServiceImpl();
        ArrayList<Flight> flightsByWay = flightService.getFlightsByWay(1, 2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(flightsByWay.size(), 1);
        softAssert.assertEquals(flightsByWay.get(0).getIdFlight(), 1);
        ArrayList<Flight> flightsByWayAndCategory = flightService.getFlightsByWay(2, 3, "VIP");
        softAssert.assertEquals(flightsByWayAndCategory.size(),1);
        softAssert.assertAll();
        softAssert.assertEquals(flightsByWayAndCategory.get(0).getIdFlight(), 2);
        softAssert.assertAll();
    }

    @Test
    public void planeModelServiceTest(){
        PlaneModelServiceImpl planeModelService = new PlaneModelServiceImpl();
        PlaneModel planeModel = planeModelService.getPlaneModelById(1);
        Assert.assertEquals(planeModel.getPlaneModelName(), "A-202");
    }

    @Test
    public void planeServiceTest(){
        PlaneServiceImpl planeService = new PlaneServiceImpl();
        Plane plane = planeService.getPlaneById(1);
        Assert.assertEquals(plane.getModelId(), 1);
    }
}

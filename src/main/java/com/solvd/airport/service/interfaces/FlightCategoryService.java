package com.solvd.airport.service.interfaces;

import com.solvd.airport.binary.FlightCategory;

import java.util.HashMap;

public interface FlightCategoryService {

    HashMap<Long, FlightCategory> getFlightCategoriesHashMap();

}

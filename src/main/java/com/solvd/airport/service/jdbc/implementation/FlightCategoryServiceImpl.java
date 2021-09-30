package com.solvd.airport.service.jdbc.implementation;

import com.solvd.airport.binary.FlightCategory;
import com.solvd.airport.dao.jdbc.impl.FlightCategoryDaoImpl;
import com.solvd.airport.service.interfaces.FlightCategoryService;

import java.util.HashMap;

public class FlightCategoryServiceImpl implements FlightCategoryService {
    @Override
    public HashMap<Long, FlightCategory> getFlightCategoriesHashMap() {
        HashMap<Long, FlightCategory> result = new HashMap<>();
        FlightCategory flightCategory;
        long id = 1;
        while (true){
            FlightCategoryDaoImpl flightCategoryDao = new FlightCategoryDaoImpl();
            flightCategory = flightCategoryDao.getById(id);
            id++;
            if(flightCategory!=null){
                result.put(flightCategory.getIdFlightCategory(), flightCategory);
            }
            else break;
        }
        return result;
    }
}

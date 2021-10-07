package com.solvd.airport;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.airport.binary.Airport;
import com.solvd.airport.binary.Country;
import com.solvd.airport.binary.Town;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserTest {

    ObjectMapper objectMapper;
    @BeforeTest
    public void createObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void jacksonWriteObject(){
        Country country = new Country();
        country.setIdCountry(1);
        country.setCountryName("Ukraine");
        ArrayList<Town> towns = new ArrayList<>();
        Town town1 = new Town();
        town1.setIdTown(1);
        town1.setTownName("Kyiv");
        ArrayList<Airport> airports1 = new ArrayList<>();
        Airport airport1 = new Airport();
        airport1.setIdAirport(1);
        airport1.setAirportName("Boryspil");
        airport1.setPassengersPerDay(100);
        Airport airport2 = new Airport();
        airport2.setIdAirport(2);
        airport2.setAirportName("Zhulyany");
        airport2.setPassengersPerDay(50);
        airports1.add(airport1);
        airports1.add(airport2);
        town1.setAirports(airports1);
        towns.add(town1);
        Town town2 = new Town();
        town2.setIdTown(2);
        town2.setTownName("Vinnytsya");
        ArrayList<Airport> airports2 = new ArrayList<>();
        Airport airport3 = new Airport();
        airport3.setIdAirport(3);
        airport3.setAirportName("Airport of Vinnytsya");
        airport3.setPassengersPerDay(25);
        airports2.add(airport3);
        town2.setAirports(airports2);
        towns.add(town2);
        country.setTowns(towns);
        List<Country> countryList = new ArrayList<>();
        countryList.add(country);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/wcountry.json"), countryList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            String expJson = FileUtils.readFileToString(new File("src/test/resources/country.json"));
            String actJson = FileUtils.readFileToString(new File("src/test/resources/wcountry.json"));
            JSONAssert.assertEquals(actJson, expJson, JSONCompareMode.STRICT);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void jacksonReadObject(){
        try {
            List<Country> countryList = objectMapper.readValue(new File("src/test/resources/country.json"), new TypeReference<List<Country>>(){});
            Assert.assertEquals(countryList.size(), 1);
            Assert.assertEquals(countryList.get(0).getTowns().size(), 2);
            Assert.assertEquals(countryList.get(0).getTowns().get(1).getAirports().size(),1);
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

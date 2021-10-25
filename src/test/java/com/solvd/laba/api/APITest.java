package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.annotations.Test;


public class APITest implements IAbstractTest {
    private final static String CITY = "Donetsk";
    private final static String UNCORRECT_CITY = "Donetsktest";

    @Test
    @MethodOwner(owner = "yerozhenko")
    public void apiWeatherInCityTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("api/_get/weather-rs.schema");
    }

    @Test
    public void apiWeatherInUncorrectCityTest() {
        GetWeatherByUncorrectCityMethod getWeatherByUncorCity = new GetWeatherByUncorrectCityMethod(UNCORRECT_CITY);
        getWeatherByUncorCity.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getWeatherByUncorCity.callAPI();
    }

    @Test
    public void apiCurrentAirPollutionDataTest() {
        GetCurrentAirPollutionData getCurrentAirPollutionData = new GetCurrentAirPollutionData(50, 50);
        getCurrentAirPollutionData.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCurrentAirPollutionData.callAPI();
        getCurrentAirPollutionData.validateResponseAgainstSchema("api/_get/air-pollution-rs-schema.json");
    }

    @Test
    @MethodOwner(owner = "yerozhenko")
    public void apiOnlinerAccountCreationTest() {
        CreateNewAccountMethod createNewAccountMethod = new CreateNewAccountMethod();
        createNewAccountMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        createNewAccountMethod.callAPI();
        createNewAccountMethod.validateResponseAgainstSchema("api/_post/rs-onliner-scheme.json");
    }

    @Test
    public void apiBooksSearchTest() {
        SearchBooks searchBooks = new SearchBooks("Star Wars");
        searchBooks.expectResponseStatus(HttpResponseStatusType.OK_200);
        searchBooks.callAPI();
    }
}

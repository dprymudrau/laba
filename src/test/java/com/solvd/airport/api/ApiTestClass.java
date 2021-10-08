package com.solvd.airport.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ApiTestClass implements IAbstractTest {

    @Test
    public void GetWeatherByCityTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod("Kyiv");
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        //getWeatherByCityMethod.validateResponseAgainstSchema("C:\\Users\\User\\IdeaProjects\\laba\\src\\test\\resources\\schemas\\weather-by-city.json");
    }

    @Test
    public void GetForecastByCity(){
        GetForecastByCityMethod getForecastByCityMethod = new GetForecastByCityMethod("München","DE");
        getForecastByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getForecastByCityMethod.callAPI();
       // getForecastByCityMethod.validateResponseAgainstSchema("src/test/resources/schemas/forecast-by-city.json");
    }

}

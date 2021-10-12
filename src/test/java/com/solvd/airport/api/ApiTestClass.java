package com.solvd.airport.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ApiTestClass implements IAbstractTest {

    @Test
    public void getWeatherByCityTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod("Kyiv");
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-city.json");
    }

    @Test
    public void getForecastByCityTest(){
        GetForecastByCityMethod getForecastByCityMethod = new GetForecastByCityMethod("München","DE");
        getForecastByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getForecastByCityMethod.callAPI();
        getForecastByCityMethod.validateResponseAgainstSchema("schemas/forecast-by-city.json");
    }

    @Test
    public void getWeatherByCoords(){
        GetWeatherByCoordsMethod getWeatherByCoordsMethod = new GetWeatherByCoordsMethod("33.44", "-94.04", "hourly,daily");
        getWeatherByCoordsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCoordsMethod.callAPI();
        getWeatherByCoordsMethod.validateResponseAgainstSchema("schemas/weather-by-coords.json");

    }

    @Test
    public void getHistoricalForecastTest(){
        GetHistoricalForecastForCityMethod getHistoricalForecastForCityMethod = new GetHistoricalForecastForCityMethod("London", "UK");
        getHistoricalForecastForCityMethod.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
    }

    @Test
    public void postRegisterMethodTest(){
        PostRegisterMethod postRegisterMethod = new PostRegisterMethod();
        postRegisterMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postRegisterMethod.callAPI();
        postRegisterMethod.validateResponse();
    }
}

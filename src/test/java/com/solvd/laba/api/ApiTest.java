package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {
    private final static String CITY_KIEV = "Kyiv";
    private final static String CITY_CODE = "380";

    private final static String CITY_TOKIO = "Tokio";
    private final static String CITY_YAKOHAMA = "Yokohama";
    private final static String CITY_OSAKA = "Osaka";
    private final static String CITY_NAGOYA = "Nagoya";
    private final static String CITY_SAPPORO = "Sapporo";

    // @Test
    public void getClimateForecastTest() {
        GetClimateForecastMethod getClimateForecastMethod = new GetClimateForecastMethod(CITY_KIEV, CITY_CODE);
        getClimateForecastMethod.callAPIExpectSuccess();
        getClimateForecastMethod.validateResponse();
    }

    @Test
    public void getWeatherByTokioTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_TOKIO);
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-tokio.schema");
    }

    @Test
    public void getWeatherByYokohamaTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_YAKOHAMA);
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-yokohama.schema");
    }

    @Test
    public void getWeatherByOsakaTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_OSAKA);
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-osaka.schema");
    }

    @Test
    public void getWeatherByNagoyaTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_NAGOYA);
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-nagoya.schema");
    }

    @Test
    public void getWeatherBySapporoTest() {
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_SAPPORO);
        getWeatherByCityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherByCityMethod.callAPI();
        getWeatherByCityMethod.validateResponseAgainstSchema("schemas/weather-by-sapporo.schema");
    }

    @Test
    public void postRegisterTest() {
        PostRegisterMethod postRegisterMethod = new PostRegisterMethod();
        postRegisterMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postRegisterMethod.callAPI();
        postRegisterMethod.validateResponse();
    }
}

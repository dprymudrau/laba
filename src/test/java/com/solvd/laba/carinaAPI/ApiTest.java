package com.solvd.laba.carinaAPI;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.solvd.laba.api.GetWeatherByCityMethod;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {
    private final static String CITY_KIEV = "Kiev";
    private final static String CITY_MINSK = "Minsk";
    private final static String CITY_LONDON = "London";
    private final static String CITY_TOKIO = "Tokio";
    private final static String CITY_MADRID = "Madrid";

    @Test
    public void apiWeatherKievTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_KIEV);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileKyiv.schema");
    }
    @Test
    public void apiWeatherMinskTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_MINSK);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileMinsk.schema");
    }
    @Test
    public void apiWeatherLondonTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_LONDON);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileLondon.schema");
    }
    @Test
    public void apiWeatherTokioTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_TOKIO);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileTokio.schema");
    }
    @Test
    public void apiWeatherMadridTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_MADRID);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileMadrid.schema");
    }
}

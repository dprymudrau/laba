package com.solvd.laba;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.api.GetWeatherByCityMethod;
import org.testng.annotations.Test;

public class ApiTest implements IAbstractTest {
    private final static String CITY_KIEV = "Kiev";
    private final static String CITY_MINSK = "Minsk";
    private final static String CITY_LONDON = "London";
    private final static String CITY_SEUL = "Seul";
    private final static String CITY_PARIS = "Paris";

    @Test
    public void apiWeatherKievTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_KIEV);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileKiev.schema");
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
    public void apiWeatherSeulTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_SEUL);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileSeul.schema");
    }
    @Test
    public void apiWeatherParisTest(){
        GetWeatherByCityMethod getWeatherByCityMethod = new GetWeatherByCityMethod(CITY_PARIS);
        getWeatherByCityMethod.callAPIExpectSuccess();
        getWeatherByCityMethod.validateResponseAgainstSchema("apiTests2/fileParis.schema");
    }
}

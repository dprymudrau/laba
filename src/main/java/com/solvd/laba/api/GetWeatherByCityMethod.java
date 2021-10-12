package com.solvd.laba.api;

public class GetWeatherByCityMethod extends AbstractApiMethodV2 {
    public class GetWeatherByCityMethod extends AbstractApiMethodV2 {
        public GetWeatherByCityMethod(String city){
            replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
            replaceUrlPlaceholder("city_name", city);
            replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
        }
}

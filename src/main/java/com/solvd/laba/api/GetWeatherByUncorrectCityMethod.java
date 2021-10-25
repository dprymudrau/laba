package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByUncorrectCityMethod extends AbstractApiMethodV2 {

    public GetWeatherByUncorrectCityMethod(String cityName) {
        super(null, "api/_get/weather-error-response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city_name", cityName);
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}

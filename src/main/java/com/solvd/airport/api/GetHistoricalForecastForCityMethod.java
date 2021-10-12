package com.solvd.airport.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetHistoricalForecastForCityMethod extends AbstractApiMethodV2 {
    public GetHistoricalForecastForCityMethod(String city, String code){
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city_id", city);
        replaceUrlPlaceholder("country_code", code);
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}

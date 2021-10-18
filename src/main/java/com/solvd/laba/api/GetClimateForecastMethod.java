package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetClimateForecastMethod extends AbstractApiMethodV2 {

    public GetClimateForecastMethod(String city, String code) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city_name", city);
        replaceUrlPlaceholder("country_code", code);
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}

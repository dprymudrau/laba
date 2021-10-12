package com.solvd.airport.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherByCoordsMethod extends AbstractApiMethodV2 {

    public GetWeatherByCoordsMethod(String lat, String lon, String part) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("lat", lat);
        replaceUrlPlaceholder("lon", lon);
        replaceUrlPlaceholder("part", part);
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }

}

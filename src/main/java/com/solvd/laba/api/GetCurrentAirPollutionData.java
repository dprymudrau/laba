package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCurrentAirPollutionData extends AbstractApiMethodV2 {

    public GetCurrentAirPollutionData(Number latitude, Number longitude) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("lat", String.valueOf(latitude));
        replaceUrlPlaceholder("lon", String.valueOf(longitude));
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}

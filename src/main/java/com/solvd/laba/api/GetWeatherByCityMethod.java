package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherByCityMethod extends AbstractApiMethodV2 {

    public GetWeatherByCityMethod(String cityName) {
        super(null, "api/_get/weather-response.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city_name", cityName);
        replaceUrlPlaceholder("api_key", Configuration.getEnvArg("api_key"));
    }
}

package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import static com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType.OK_200;

//@SuccessfulHttpStatus(status = OK_200)
public class GetWeatherByCityMethod extends AbstractApiMethodV2 {

    public GetWeatherByCityMethod(String cityName){
        replaceUrlPlaceholder("base_Url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("city_Name", cityName);
        //replaceUrlPlaceholder("api_key", CryptuUtil.decrypt(R.CONFIG.get("api_key")));

    }

}

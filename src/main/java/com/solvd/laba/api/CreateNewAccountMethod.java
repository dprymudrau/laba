package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class CreateNewAccountMethod extends AbstractApiMethodV2 {

    public CreateNewAccountMethod() {
        super("api/_post/rq-onliner.json", "api/_post/response-onliner.json", "api/create-account.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}

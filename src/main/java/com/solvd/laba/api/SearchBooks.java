package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class SearchBooks extends AbstractApiMethodV2 {

    public SearchBooks(String searchWords) {
        searchWords = searchWords.toLowerCase().replace(" ", "+");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("entity", searchWords);
    }
}

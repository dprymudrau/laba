package com.solvd.laba.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostRegisterMethod extends AbstractApiMethodV2 {
    public PostRegisterMethod() {

        super("_post/rq.json", "_post/rs.json", "_user.properties");
        replaceUrlPlaceholder("base_url", ("https://reqbin.com/echo/post/json"));
    }
}


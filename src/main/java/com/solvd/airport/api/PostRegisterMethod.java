package com.solvd.airport.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

public class PostRegisterMethod extends AbstractApiMethodV2 {
    public PostRegisterMethod(){
        super("register.json", "rs.json", "register.properties");
        replaceUrlPlaceholder("base_url", "https://reqbin.com/echo/post/json");
    }
}

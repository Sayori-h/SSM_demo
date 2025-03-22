package com.powernode.controller;

import com.powernode.entity.ApiConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ConfigController {

    @Resource
    ApiConfig apiConfig;
    @RequestMapping(value = "/web/api")
    public @ResponseBody String webApi() {
        return apiConfig.getEndpoint()+":"+apiConfig.getTimeout();
    }
}

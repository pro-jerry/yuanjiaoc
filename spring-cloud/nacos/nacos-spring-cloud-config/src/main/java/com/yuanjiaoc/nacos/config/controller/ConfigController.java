package com.yuanjiaoc.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月29日
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${common.name}")
    private String name;

    @Value("${common.name1}")
    private String name1;

    @RequestMapping("/config")
    public String get() {
        return name + "------" + name1;
    }
}

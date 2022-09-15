package com.yuanjiaoc.nacos.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月15日
 */
@RestController
public class ProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class);

    @RequestMapping("/service")
    public String service() {
        LOG.info("provider invoke");
        return "provider invoke";
    }
}

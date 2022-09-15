package com.yuanjiaoc.nacos.consumer.controller;

import com.yuanjiaoc.nacos.consumer.remote.RemoteProvider;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月29日
 */
@RestController
public class ConsumerController {

    @Resource
    private RemoteProvider remoteProvider;

    @GetMapping(value = "/consumer")
    public String consumber() {
        return "consumber";
    }

    @GetMapping(value = "/consumer0")
    public String consumber0() {
        return remoteProvider.service();
    }


}

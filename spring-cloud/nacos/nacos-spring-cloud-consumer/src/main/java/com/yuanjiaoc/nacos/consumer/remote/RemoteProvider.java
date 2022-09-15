package com.yuanjiaoc.nacos.consumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月15日
 */
@FeignClient(name = "nacos-provider", url = "http://127.0.0.1:8090/nacosProvider")
public interface RemoteProvider {

    @GetMapping("/service")
    String service();
}

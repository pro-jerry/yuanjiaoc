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
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

  @Value("${useLocalCache:false}")
  private boolean useLocalCache;

  @RequestMapping("/get")
  public boolean get() {
    return useLocalCache;
  }
}

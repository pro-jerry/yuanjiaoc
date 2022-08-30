package com.yuanjiaoc.nacos.provider;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月29日
 */
@RestController
public class ConfigController {

  @Value("${project.name}")
  private String projectName;

  @Value("${project.org}")
  private String projectOrg;

  @GetMapping("/config")
  public Map<String, Object> getConfig() {
    Map<String, Object> configMap = new HashMap();
    configMap.put("projectName", projectName);
    configMap.put("projectOrg", projectOrg);
    return configMap;
  }
}

package com.yuanjiaoc.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月29日
 */
@RestController
public class TestController {

  private final RestTemplate restTemplate;

  @Autowired
  public TestController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
  public String echo(@PathVariable String str) {
    return restTemplate.getForObject("http://localhost:8070/echo/" + str, String.class);
  }
}

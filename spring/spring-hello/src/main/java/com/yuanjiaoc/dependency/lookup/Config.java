package com.yuanjiaoc.dependency.lookup;

import org.springframework.context.annotation.Bean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class Config {

  @Bean
  public SuperRumenz superRumenz() {
    SuperRumenz s = new SuperRumenz();
    s.setKey("超级管理员");
    return s;
  }
}

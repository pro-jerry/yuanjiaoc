package com.yuanjiaoc.dependency.lookup;

import org.springframework.context.annotation.Bean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class Config1 {

  @Bean
  public static Rumenz rumenz() {
    Rumenz r = new Rumenz();
    r.setId(123);
    r.setName("入门小站");
    return r;
  }
}

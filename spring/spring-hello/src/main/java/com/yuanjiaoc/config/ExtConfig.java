package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月08日
 */
@Configuration
@ComponentScan(value = "com.yuanjiaoc.listener")
public class ExtConfig {

  @Bean
  public Person person() {
    return new Person();
  }
}

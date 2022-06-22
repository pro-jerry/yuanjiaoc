package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Configuration
@ComponentScan(value = "com.yuanjiaoc")
public class PersonConfig {

  @Bean("person")
  public Person person01() {
    return new Person("yuan", 12);
  }
}

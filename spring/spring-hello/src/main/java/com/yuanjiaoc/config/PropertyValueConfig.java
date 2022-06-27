package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 测试属性赋值.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月26日
 */
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class PropertyValueConfig {

  @Bean
  public Person person() {
    return new Person();
  }
}

package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
@Configuration
public class PersonConfig3 {

  @Scope("thread")
  @Bean("person")
  public Person person() {
    System.out.println("给容器中添加Person....");
    return new Person("binghe002", 18);
  }
}

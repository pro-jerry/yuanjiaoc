package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Animal;
import com.yuanjiaoc.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
@Configuration
@ComponentScan("com.yuanjiaoc.bean")
public class AnimalConfig {

  @Bean
  //  @Scope("prototype")
  public Animal animal() {

    return new Animal();
  }

  @Bean(initMethod = "init", destroyMethod = "destroy")
  public Cat cat() {
    return new Cat();
  }
}

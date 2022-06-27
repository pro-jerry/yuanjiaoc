package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean的生命周期.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
@Configuration
public class LifeCircleConfig {

  //  @Scope("prototype")
  @Bean(initMethod = "init", destroyMethod = "destroy")
  public Student student() {
    return new Student();
  }
}

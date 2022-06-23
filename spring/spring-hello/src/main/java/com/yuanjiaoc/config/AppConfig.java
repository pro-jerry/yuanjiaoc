package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.StudentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月23日
 */
@Configuration
public class AppConfig {

  @Bean
  public StudentBean studentBean() {
    StudentBean studentBean = new StudentBean();
    studentBean.setId(19);
    studentBean.setName("admin");
    return studentBean;
  }
}

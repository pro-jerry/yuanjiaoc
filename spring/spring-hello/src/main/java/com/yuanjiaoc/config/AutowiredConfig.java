package com.yuanjiaoc.config;

import com.yuanjiaoc.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Configuration
@ComponentScan(value = {"com.yuanjiaoc.dao", "com.yuanjiaoc.service", "com.yuanjiaoc.controller"})
public class AutowiredConfig {

  @Primary
  @Bean("personDao2")
  public PersonDao personDao() {
    PersonDao personDao = new PersonDao();
    personDao.setRemark("2");
    return personDao;
  }
}

package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.filter.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Configuration
@ComponentScan(
    value = "com.yuanjiaoc",
    includeFilters = {
      @Filter(
          type = FilterType.CUSTOM,
          classes = {MyTypeFilter.class})
    },
    useDefaultFilters = false)
public class PersonConfig {

  @Bean("person")
  public Person person01() {
    return new Person("yuan", 12, "");
  }
}

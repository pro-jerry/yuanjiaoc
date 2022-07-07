package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.MyBeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月06日
 */
@Configuration
public class BeanFactoryPostProcessorConfig {

  //  @Bean
  //  public BeanFactoryPostProcessorBean beanFactoryPostProcessorBean() {
  //
  //    return new BeanFactoryPostProcessorBean();
  //  }

  @Bean
  public MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor() {

    return new MyBeanDefinitionRegistryPostProcessor();
  }
}

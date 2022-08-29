package com.yuanjiaoc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  public MyBeanFactoryPostProcessor() {
    super();
    System.out.println("这是BeanFactoryPostProcessor实现类构造器！！---1");
  }

  @Override
  public void postProcessBeanFactory(
      ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法---2");
    BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("student");
    bd.getPropertyValues().addPropertyValue("phone", "110");
  }
}

package com.yuanjiaoc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * bean定义加载完毕，bean实例化前后，bean初始化前后
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月08日
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

    // 获取已经加载的bean定义的数量
    int count = beanFactory.getBeanDefinitionCount();
    // 获取已经加载的bean定义的名称
    String[] beanNames = beanFactory.getBeanDefinitionNames();

    // 根据bean定义的名称获取具体的bean定义
    BeanDefinition perBeanDefinition = beanFactory.getBeanDefinition("person");
    // 修改bean定义，bean定义中的许多属性此处都可以修改
    // 修改之后，创建bean实例的时候就会应用到修改之后的新属性值
    perBeanDefinition.setAutowireCandidate(false);
    System.out.println("------------>" + perBeanDefinition);
  }
}

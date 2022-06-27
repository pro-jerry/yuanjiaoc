package com.yuanjiaoc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 测试BeanPostProcessor.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println(
        "调用了postProcessBeforeInitialization方法，beanName = " + beanName + ", bean = " + bean);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println(
        "调用了postProcessAfterInitialization，beanName = " + beanName + ", bean = " + bean);
    return bean;
  }

  @Override
  public int getOrder() {
    return 3;
  }
}

package com.yuanjiaoc.lifecycle;

import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class MyInstantiationAwareBeanPostProcessor
    extends InstantiationAwareBeanPostProcessorAdapter {

  public MyInstantiationAwareBeanPostProcessor() {
    super();
    System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！---4");
  }

  // 接口方法、实例化Bean之前调用
  @Override
  public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
      throws BeansException {
    System.out.println(
        "InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法 ---5");
    return null;
  }

  // 接口方法、实例化Bean之后调用
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println(
        "InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法 ---17");
    return bean;
  }

  // 接口方法、设置某个属性时调用
  @Override
  public PropertyValues postProcessPropertyValues(
      PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
      throws BeansException {
    System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法 ---7");
    return pvs;
  }
}

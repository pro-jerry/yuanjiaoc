package com.yuanjiaoc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  public MyBeanPostProcessor() {
    System.out.println("这是BeanPostProcessor实现类构造器！！---3");
  }

  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改---13");
    return o;
  }

  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改 ---16");
    return o;
  }
}

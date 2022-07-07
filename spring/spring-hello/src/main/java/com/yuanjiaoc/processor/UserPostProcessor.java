package com.yuanjiaoc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月06日
 */
public class UserPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    if (o instanceof User) {
      User user = (User) o;
      user.setName("新名字");
      user.setId(100);
      return user;
    }
    return o;
  }

  @Override
  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    return o;
  }
}

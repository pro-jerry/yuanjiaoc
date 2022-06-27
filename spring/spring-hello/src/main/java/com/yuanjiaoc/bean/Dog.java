package com.yuanjiaoc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
@Component
public class Dog implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  public Dog() {
    System.out.println("dog constructor...");
  }

  // 对象创建并赋值之后调用
  @PostConstruct
  public void init() {
    System.out.println("Dog....@PostConstruct...");
  }
  // 容器移除对象之前
  @PreDestroy
  public void detory() {
    System.out.println("Dog....@PreDestroy...");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }
}

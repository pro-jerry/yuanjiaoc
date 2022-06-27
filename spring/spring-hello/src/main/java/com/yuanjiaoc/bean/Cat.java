package com.yuanjiaoc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
  public Cat() {
    System.out.println("Cat类的构造方法...");
  }

  public void init() {
    System.out.println("Cat的init()方法...");
  }

  public void destroy() {
    System.out.println("Cat的destroy()方法...");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("cat...afterPropertiesSet...");
  }
}

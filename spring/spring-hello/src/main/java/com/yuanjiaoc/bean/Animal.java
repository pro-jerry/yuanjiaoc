package com.yuanjiaoc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 测试InitializingBean接口和DisposableBean接口.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
public class Animal implements InitializingBean, DisposableBean {

  public Animal() {
    System.out.println("执行了Animal类的无参数构造方法");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("执行了Animal类的初始化方法。。。。。");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("执行了Animal类的销毁方法。。。。。");
  }
}

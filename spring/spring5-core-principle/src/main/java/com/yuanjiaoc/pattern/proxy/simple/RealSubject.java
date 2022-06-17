package com.yuanjiaoc.pattern.proxy.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class RealSubject implements Subject {

  @Override
  public void request() {
    System.out.println("real service is called.");
  }
}

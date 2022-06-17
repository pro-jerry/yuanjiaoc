package com.yuanjiaoc.pattern.proxy.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Proxy implements Subject {

  private final Subject subject;

  public Proxy(Subject subject) {
    this.subject = subject;
  }

  @Override
  public void request() {
    before();
    subject.request();
    after();
  }

  public void before() {
    System.out.println("called before request().");
  }

  public void after() {
    System.out.println("called after request().");
  }
}

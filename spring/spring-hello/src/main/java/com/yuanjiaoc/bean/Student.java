package com.yuanjiaoc.bean;

/**
 * 测试bean的初始化和销毁方法.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
public class Student {
  public Student() {
    System.out.println("Student类的构造方法");
  }

  public void init() {
    System.out.println("初始化Student对象");
  }

  public void destroy() {
    System.out.println("销毁Student对象");
  }
}

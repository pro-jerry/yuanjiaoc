package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class AbstractFactoryTest {

  public static void main(String[] args) {

    JavaCourseFactory courseFactory = new JavaCourseFactory();
    courseFactory.createNote().edit();
  }
}

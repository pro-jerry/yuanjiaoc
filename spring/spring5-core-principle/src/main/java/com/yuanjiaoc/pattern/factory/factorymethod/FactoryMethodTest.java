package com.yuanjiaoc.pattern.factory.factorymethod;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class FactoryMethodTest {

  public static void main(String[] args) {

    ICourseFactory iCourseFactory = new PythonCourseFactory();
    iCourseFactory.create().record();
  }
}

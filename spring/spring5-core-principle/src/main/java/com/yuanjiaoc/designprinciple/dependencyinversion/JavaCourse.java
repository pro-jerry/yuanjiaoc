package com.yuanjiaoc.designprinciple.dependencyinversion;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class JavaCourse implements ICourse {

  @Override
  public void study() {
    System.out.println("Tom在学习Java课程");
  }
}

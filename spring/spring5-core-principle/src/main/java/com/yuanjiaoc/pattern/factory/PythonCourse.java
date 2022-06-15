package com.yuanjiaoc.pattern.factory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class PythonCourse implements ICourse {

  @Override
  public void record() {
    System.out.println("录制Python课程");
  }
}

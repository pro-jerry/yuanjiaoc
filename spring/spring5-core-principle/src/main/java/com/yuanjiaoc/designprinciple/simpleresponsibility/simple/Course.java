package com.yuanjiaoc.designprinciple.simpleresponsibility.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Course {

  public void study(String courseName) {
    if ("直播课".equals(courseName)) {
      System.out.println(courseName + "不能快进");
    } else {
      System.out.println(courseName + "可以反复回看");
    }
  }
}

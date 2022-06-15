package com.yuanjiaoc.designprinciple.simpleresponsibility.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class ReplayCourse {
  public void study(String courseName) {
    System.out.println(courseName + "不能快进");
  }
}

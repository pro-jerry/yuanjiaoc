package com.yuanjiaoc.designprinciple.simpleresponsibility;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public interface ICourse {

  // 获得基本信息
  String getCourseName();

  // 获得视频流
  byte[] getCourseVideo();

  // 学习课程
  void studyCourse();
  // 退款
  void refundCourse();
}

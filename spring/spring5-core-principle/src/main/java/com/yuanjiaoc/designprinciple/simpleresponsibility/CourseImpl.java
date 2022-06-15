package com.yuanjiaoc.designprinciple.simpleresponsibility;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class CourseImpl implements ICourse, ICourseInfo {

  @Override
  public String getCourseName() {
    return null;
  }

  @Override
  public byte[] getCourseVideo() {
    return new byte[0];
  }

  @Override
  public void studyCourse() {}

  @Override
  public void refundCourse() {}
}

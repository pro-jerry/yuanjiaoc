package com.yuanjiaoc.designprinciple.simpleresponsibility;

import com.yuanjiaoc.designprinciple.simpleresponsibility.simple.Course;
import com.yuanjiaoc.designprinciple.simpleresponsibility.simple.LiveCourse;
import com.yuanjiaoc.designprinciple.simpleresponsibility.simple.ReplayCourse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class SingleResponsibilityTest {

  public static void main(String[] args) {

    Course course = new Course();
    course.study("直播课");
    course.study("录播课");

    LiveCourse liveCourse = new LiveCourse();
    liveCourse.study("直播课");

    ReplayCourse replayCourse = new ReplayCourse();
    replayCourse.study("录播课");
  }
}

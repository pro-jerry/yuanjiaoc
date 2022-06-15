package com.yuanjiaoc.designprinciple.dependencyinversion;

import lombok.NoArgsConstructor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
@NoArgsConstructor
public class Tom {

  private ICourse course;

  // 构造器注入
  public Tom(ICourse course) {
    this.course = course;
  }

  // Setter 注入
  public void setCourse(ICourse course) {
    this.course = course;
  }

  public void study() {
    course.study();
  }

  public void study(ICourse course) {
    course.study();
  }

  public void studyJavaCourse() {
    System.out.println("Tom在学习Java的课程");
  }

  public void studyPythonCourse() {
    System.out.println("Tom在学习Python的课程");
  }
}

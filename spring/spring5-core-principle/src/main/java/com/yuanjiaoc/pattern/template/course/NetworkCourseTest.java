package com.yuanjiaoc.pattern.template.course;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public class NetworkCourseTest {

  public static void main(String[] args) {

    System.out.println("---Java架构师课程---");
    NetworkCourse javaCourse = new JavaCourse();
    javaCourse.createCourse();

    System.out.println("---大数据课程---");
    NetworkCourse bigDataCourse = new BigDataCourse(true);
    bigDataCourse.createCourse();
  }
}

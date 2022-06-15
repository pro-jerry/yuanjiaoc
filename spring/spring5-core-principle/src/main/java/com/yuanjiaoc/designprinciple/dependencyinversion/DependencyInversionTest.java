package com.yuanjiaoc.designprinciple.dependencyinversion;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class DependencyInversionTest {

  public static void main(String[] args) {

    // v1
    //    Tom tom = new Tom();
    //    tom.studyJavaCourse();
    //    tom.studyPythonCourse();

    // v2
    //    Tom tom = new Tom();
    //    tom.study(new JavaCourse());
    //    tom.study(new PythonCourse());

    // v3 构造器注入
    //    Tom tom = new Tom(new JavaCourse());
    //    tom.study();

    // v4 setter注入
    Tom tom = new Tom();
    tom.setCourse(new JavaCourse());
    tom.study();
  }
}

package com.yuanjiaoc.pattern.factory.simplefactory;

import com.yuanjiaoc.pattern.factory.ICourse;
import com.yuanjiaoc.pattern.factory.JavaCourse;
import com.yuanjiaoc.pattern.factory.PythonCourse;

/**
 * 简单工厂.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class SimpleFactoryTest {

  public static void main(String[] args) {

    ICourse iCourse0 = new JavaCourse();
    iCourse0.record();

    CourseFactory courseFactory = new CourseFactory();
    ICourse iCourse = courseFactory.create("java");
    iCourse.record();

    ICourse iCourse1 = courseFactory.createByReflect("com.yuanjiaoc.pattern.factory.PythonCourse");
    iCourse1.record();

    ICourse iCourse2 = courseFactory.createFinal(PythonCourse.class);
    iCourse2.record();
  }
}

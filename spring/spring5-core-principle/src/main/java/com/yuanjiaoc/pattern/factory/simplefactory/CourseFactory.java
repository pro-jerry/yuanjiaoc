package com.yuanjiaoc.pattern.factory.simplefactory;

import com.yuanjiaoc.pattern.factory.ICourse;
import com.yuanjiaoc.pattern.factory.JavaCourse;
import com.yuanjiaoc.pattern.factory.PythonCourse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class CourseFactory {

  public ICourse create(String name) {

    if ("java".equals(name)) {
      return new JavaCourse();
    } else if ("python".equals(name)) {
      return new PythonCourse();
    } else {
      return null;
    }
  }

  public ICourse createByReflect(String className) {

    try {
      if (!(className == null || "".equals(className))) {

        return (ICourse) Class.forName(className).newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public ICourse createFinal(Class<? extends ICourse> clazz) {

    try {
      if (clazz != null) {
        return clazz.newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

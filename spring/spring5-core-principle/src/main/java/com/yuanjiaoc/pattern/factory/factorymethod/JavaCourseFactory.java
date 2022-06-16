package com.yuanjiaoc.pattern.factory.factorymethod;

import com.yuanjiaoc.pattern.factory.ICourse;
import com.yuanjiaoc.pattern.factory.JavaCourse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class JavaCourseFactory implements ICourseFactory {

  @Override
  public ICourse create() {
    return new JavaCourse();
  }
}

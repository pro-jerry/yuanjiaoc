package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class PythonCourseFactory implements CourseFactory {

  @Override
  public INote createNote() {
    return new PythonNote();
  }

  @Override
  public IVideo createVideo() {
    return new PythonVideo();
  }
}

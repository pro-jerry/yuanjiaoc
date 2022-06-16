package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class JavaCourseFactory implements CourseFactory {

  @Override
  public INote createNote() {
    return new JavaNote();
  }

  @Override
  public IVideo createVideo() {
    return new JavaVideo();
  }
}

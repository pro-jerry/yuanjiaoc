package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public interface CourseFactory {

  INote createNote();

  IVideo createVideo();
}

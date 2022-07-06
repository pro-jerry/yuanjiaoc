package com.yuanjiaoc.java8features;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月01日
 */
public class AnnotationTest {

  public static void main(String[] args) {

    Class<SonClass> sonClassClass = SonClass.class;
    MyAnnotation annotation = sonClassClass.getAnnotation(MyAnnotation.class);
  }
}

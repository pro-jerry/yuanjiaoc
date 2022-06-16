package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class JavaNote implements INote {

  @Override
  public void edit() {
    System.out.println("编写Java笔记");
  }
}

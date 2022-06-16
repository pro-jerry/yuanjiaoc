package com.yuanjiaoc.pattern.factory.abstractfactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class PythonVideo implements IVideo {

  @Override
  public void record() {
    System.out.println("录制Python视频");
  }
}

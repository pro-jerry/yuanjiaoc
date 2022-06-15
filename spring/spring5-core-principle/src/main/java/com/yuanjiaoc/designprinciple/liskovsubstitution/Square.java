package com.yuanjiaoc.designprinciple.liskovsubstitution;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Square implements Quadrangle {

  private long length;

  public long getLength() {
    return length;
  }

  public void setLength(long length) {
    this.length = length;
  }

  @Override
  public long getWidth() {
    return length;
  }

  @Override
  public long getHeight() {
    return length;
  }
}

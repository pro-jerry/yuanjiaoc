package com.yuanjiaoc.designprinciple.liskovsubstitution;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Rectangle implements Quadrangle {

  private long height;
  private long width;

  @Override
  public long getHeight() {
    return height;
  }

  public void setHeight(long height) {
    this.height = height;
  }

  @Override
  public long getWidth() {
    return width;
  }

  public void setWidth(long width) {
    this.width = width;
  }
}

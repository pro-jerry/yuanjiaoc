package com.yuanjiaoc.designprinciple.openclose;

/**
 * Java课程活动优惠.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class JavaDiscountCourse extends JavaCourse {

  public JavaDiscountCourse(Integer id, String name, Double price) {
    super(id, name, price);
  }

  public Double getDiscountPrice() {
    return super.getPrice() * 0.85;
  }
}

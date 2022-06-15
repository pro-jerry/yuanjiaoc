package com.yuanjiaoc.designprinciple.openclose;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class OpenCloseTest {

  public static void main(String[] args) {
    ICourse iCourse = new JavaDiscountCourse(232, "Java架构师专题课", 11800D);
    JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
    System.out.println(
        "课程ID:"
            + javaCourse.getId()
            + "\n课程名称:《"
            + javaCourse.getName()
            + "》"
            + "\n原价:"
            + javaCourse.getPrice()
            + "元"
            + "\n折后价:"
            + javaCourse.getDiscountPrice()
            + "元");
  }
}

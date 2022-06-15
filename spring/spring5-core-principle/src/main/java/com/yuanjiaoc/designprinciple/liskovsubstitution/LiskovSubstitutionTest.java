package com.yuanjiaoc.designprinciple.liskovsubstitution;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class LiskovSubstitutionTest {

  public static void resize(Rectangle rectangle) {
    while (rectangle.getWidth() <= rectangle.getHeight()) {
      rectangle.setWidth(rectangle.getWidth() + 1);
      System.out.println("width:" + rectangle.getWidth() + "\nheight:" + rectangle.getHeight());
    }
    System.out.println(
        "resize方法结束" + "\nwidth:" + rectangle.getWidth() + "\nheight:" + rectangle.getHeight());
  }

  public static void main(String[] args) {

    Square square = new Square();
    square.setLength(10);
  }
}

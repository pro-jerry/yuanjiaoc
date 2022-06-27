package com.yuanjiaoc.debug;

/**
 * 断点案例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月25日
 */
public class BreakPointDemo {

  // 行断点
  public static void line() {
    System.out.println("this is the line break point ");
  }

  // 详细断点
  public static void detailLine() {
    System.out.println("this is the detail line break point ");
  }

  // 方法断点,接口跳转实现类
  public static void method() {
    System.out.println("this is the method break point");
    IService iService = new IServiceImpl();
    iService.execute();
  }

  // 异常断点|全局捕获
  public static void exception() {

    Object o = null;
    o.toString();
    System.out.println("this line will never be point");
  }

  // 字段断点,读写监控
  public static void field() {

    Person p = new Person("hello", 10);
    p.setAge(13);
    System.out.println(p);
  }

  public static void main(String[] args) {
    //    line();
    //    detailLine();
    //    method();
    //    exception();
    field();
  }
}

package com.yuanjiaoc.aop;

/**
 * 定义一个数据处理器类，用于测试AOP.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
public class MathHandler {

  public int add(int i, int j) {
    System.out.println("目标方法执行");
    throw new RuntimeException();
    //    return i + j;
  }
}

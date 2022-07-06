package com.yuanjiaoc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月05日
 */
public class TestReflect {

  @Test
  public void test01() {
    // 正常的调用
    Apple apple = new Apple();
    apple.setPrice(5);
    System.out.println("Apple Price:" + apple.getPrice());
  }

  @Test
  public void test02() throws Exception {
    // 使用反射调用
    Class clz = Class.forName("com.yuanjiaoc.reflect.Apple");
    Method setPriceMethod = clz.getMethod("setPrice", int.class);
    Constructor appleConstructor = clz.getConstructor();
    Object appleObj = clz.newInstance();
    setPriceMethod.invoke(appleObj, 14);
    Method getPriceMethod = clz.getMethod("getPrice");
    System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
  }
}

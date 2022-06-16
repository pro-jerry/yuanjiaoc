package com.yuanjiaoc.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class LazyInnerClassSingletonTest {

  public static void main(String[] args) {

    try {
      Class<?> clazz = LazyInnerClassSingleton.class;
      // 通过反射拿到私有的构造方法
      Constructor<?> c = clazz.getDeclaredConstructor(null);
      // 强制访问
      c.setAccessible(true);
      // 暴力初始化
      Object o1 = c.newInstance();
      // 调用了两次构造方法，相当于new了两次
      // 犯了原则性问题
      Object o2 = c.newInstance();
      System.out.println(o1 == o2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

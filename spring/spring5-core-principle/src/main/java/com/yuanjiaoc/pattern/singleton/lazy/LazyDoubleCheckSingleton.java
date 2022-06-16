package com.yuanjiaoc.pattern.singleton.lazy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class LazyDoubleCheckSingleton {

  private static volatile LazyDoubleCheckSingleton lazy = null;

  LazyDoubleCheckSingleton() {}

  public static LazyDoubleCheckSingleton getInstance() {

    if (lazy == null) {
      synchronized (LazyDoubleCheckSingleton.class) {
        if (lazy == null) {
          lazy = new LazyDoubleCheckSingleton();
          // 1.分配内存给这个对象
          // 2.初始化对象
          // 3.设置lazy指向刚分配的内存地址
          // 4.初次访问对象
        }
      }
    }
    return lazy;
  }
}

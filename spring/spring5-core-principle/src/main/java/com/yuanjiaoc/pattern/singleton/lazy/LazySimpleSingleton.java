package com.yuanjiaoc.pattern.singleton.lazy;

/**
 * 懒汉式单例 在外部需要使用的时候才实例化
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class LazySimpleSingleton {

  private LazySimpleSingleton() {}
  // 静态块，公共内存区域
  private static LazySimpleSingleton lazy = null;

  public static synchronized LazySimpleSingleton getInstance() {
    if (lazy == null) {
      lazy = new LazySimpleSingleton();
    }
    return lazy;
  }
}

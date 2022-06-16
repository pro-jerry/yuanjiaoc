package com.yuanjiaoc.pattern.singleton.hungry;

/**
 * 饿汉式静态代码块单例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class HungryStaticSingleton {

  private static final HungryStaticSingleton hungryStaticSingleton;

  static {
    hungryStaticSingleton = new HungryStaticSingleton();
  }

  private HungryStaticSingleton() {}

  public static HungryStaticSingleton getInstance() {
    return hungryStaticSingleton;
  }
}

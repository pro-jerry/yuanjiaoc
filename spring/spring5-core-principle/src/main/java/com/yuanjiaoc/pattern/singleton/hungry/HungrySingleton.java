package com.yuanjiaoc.pattern.singleton.hungry;

/**
 * 饿汉式单例 在类加载的时候就立刻初始化，并且创建单例对象
 *
 * <p>优点: 没有加任何的锁，执行效率高,在用户体验上来讲，比懒汉式更好
 *
 * <p>缺点:类加载的时候就初始化，不管你用与不用，都占着空间
 *
 * <p>线程绝对安全，在线程还没出现就已经初始化了，不可能存在线程安全问题.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class HungrySingleton {

  // 先静态 后动态
  // 先属性 后方法
  // 先上 后下
  private static final HungrySingleton hungrySingleton = new HungrySingleton();

  private HungrySingleton() {}

  public static HungrySingleton getInstance() {
    return hungrySingleton;
  }
}

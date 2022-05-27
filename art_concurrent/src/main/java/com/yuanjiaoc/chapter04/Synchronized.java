package com.yuanjiaoc.chapter04;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月27日
 */
public class Synchronized {

  public static void main(String[] args) {
      // 对Synchronized Class对象进行加锁
      synchronized (Synchronized.class) { }
      // 静态同步方法，对Synchronized Class对象进行加锁
      m();
  }

    public static synchronized void m() { }
}

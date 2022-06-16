package com.yuanjiaoc.pattern.singleton.lazy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class LazySimpleSingletonTest {

  public static void main(String[] args) {
    Thread t1 = new Thread(new ExectorThread());
    Thread t2 = new Thread(new ExectorThread());
    t1.start();
    t2.start();
    System.out.println("End");
  }
}

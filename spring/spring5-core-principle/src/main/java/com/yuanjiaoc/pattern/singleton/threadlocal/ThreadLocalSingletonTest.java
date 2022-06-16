package com.yuanjiaoc.pattern.singleton.threadlocal;

import com.yuanjiaoc.pattern.singleton.lazy.ExectorThread;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ThreadLocalSingletonTest {

  public static void main(String[] args) {
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());
    System.out.println(ThreadLocalSingleton.getInstance());

    Thread t1 = new Thread(new ExectorThread());
    Thread t2 = new Thread(new ExectorThread());
    t1.start();
    t2.start();
    System.out.println("End");
  }
}

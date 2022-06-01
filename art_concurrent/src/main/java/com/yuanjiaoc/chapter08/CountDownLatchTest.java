package com.yuanjiaoc.chapter08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class CountDownLatchTest {

  static CountDownLatch c = new CountDownLatch(3);

  public static void main(String[] args) throws InterruptedException {

    new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
              }
            })
        .start();

    c.await(5, TimeUnit.SECONDS);
    System.out.println("3");
  }
}

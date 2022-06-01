package com.yuanjiaoc.chapter08;

import java.util.concurrent.CyclicBarrier;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class CyclicBarrierTest2 {

  static CyclicBarrier c = new CyclicBarrier(2, new A());

  public static void main(String[] args) {
    new Thread(
            new Runnable() {

              @Override
              public void run() {
                try {
                  c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
              }
            })
        .start();

    try {
      c.await();
    } catch (Exception e) {

    }
    System.out.println(2);
  }

  static class A implements Runnable {

    @Override
    public void run() {
      System.out.println(3);
    }
  }
}

package com.yuanjiaoc.chapter08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class CyclicBarrierTest3 {

  static CyclicBarrier c = new CyclicBarrier(2);

  public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
    Thread thread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  c.await();
                } catch (Exception e) {
                }
              }
            });
    thread.start();
    thread.interrupt();
    try {
      c.await();
    } catch (Exception e) {
      System.out.println(c.isBroken());
    }
  }
}

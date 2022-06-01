package com.yuanjiaoc.chapter08;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class JoinCountDownLatchTest {

  public static void main(String[] args) throws InterruptedException {

    Thread parser1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {}
            });

    Thread parser2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println("parser2 finish");
              }
            });

    parser1.start();
    parser2.start();
    parser1.join();
    parser2.join();
    System.out.println("all parser finish");
  }
}

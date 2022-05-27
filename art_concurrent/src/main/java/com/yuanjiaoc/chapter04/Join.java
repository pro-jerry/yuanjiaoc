package com.yuanjiaoc.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月27日
 */
public class Join {

  public static void main(String[] args) throws InterruptedException {

      Thread previous = Thread.currentThread();
      for (int i = 0; i < 10; i++){
          // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
          Thread thread = new Thread(new Domino(previous), String.valueOf(i));
          thread.start();
          previous = thread;
      }
      TimeUnit.SECONDS.sleep(5);
      System.out.println(Thread.currentThread().getName() + " terminate.");
  }

    static class Domino implements Runnable {

        private final Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}

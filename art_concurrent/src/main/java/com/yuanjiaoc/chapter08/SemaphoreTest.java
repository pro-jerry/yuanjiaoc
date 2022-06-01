package com.yuanjiaoc.chapter08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class SemaphoreTest {

  private static final int THREAD_COUNT = 30;

  private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

  private static final Semaphore s = new Semaphore(10);

  public static void main(String[] args) {
    for (int i = 0; i < THREAD_COUNT; i++) {
      threadPool.execute(
          new Runnable() {
            @Override
            public void run() {
              try {
                s.acquire();
                System.out.println("save data");
                s.release();
              } catch (InterruptedException e) {
              }
            }
          });
    }

    threadPool.shutdown();
  }
}

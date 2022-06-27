package com.yuanjiaoc.debug;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月25日
 */
public class MyThread implements Runnable {

  @SneakyThrows
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "---");
    TimeUnit.SECONDS.sleep(1);
  }
}

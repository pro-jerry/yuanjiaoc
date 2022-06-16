package com.yuanjiaoc.pattern.singleton.lazy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ExectorThread implements Runnable {

  @Override
  public void run() {
    //    LazyDoubleCheckSingleton singleton = new LazyDoubleCheckSingleton();
    //    LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
    LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
    System.out.println(Thread.currentThread().getName() + ":" + singleton);
  }
}

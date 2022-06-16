package com.yuanjiaoc.pattern.singleton.threadlocal;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ThreadLocalSingleton {
  private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
      new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
          return new ThreadLocalSingleton();
        }
      };

  private ThreadLocalSingleton() {}

  public static ThreadLocalSingleton getInstance() {
    return threadLocalInstance.get();
  }
}

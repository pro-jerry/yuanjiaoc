package com.yuanjiaoc.pattern.singleton.register;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ContainerSingletonTest {

  public static void main(String[] args) {

    try {
      long start = System.currentTimeMillis();
      ConcurrentExecutor.execute(
          new ConcurrentExecutor.RunHandler() {
            public void handler() {
              Object obj =
                  ContainerSingleton.getInstance("com.yuanjiaoc.pattern.singleton.register.Pojo");
              System.out.println(System.currentTimeMillis() + ": " + obj);
            }
          },
          10,
          6);
      long end = System.currentTimeMillis();
      System.out.println("总耗时：" + (end - start) + " ms.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

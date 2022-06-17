package com.yuanjiaoc.pattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class JDKProxyTest {

  public static void main(String[] args) {

    try {
      Object obj = new JDKMeipo().getInstance(new Girl());
      Method method = obj.getClass().getMethod("findLove", null);
      method.invoke(obj);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package com.yuanjiaoc.pattern.proxy.dynamicproxy.gpproxy;

import com.yuanjiaoc.pattern.proxy.Person;
import com.yuanjiaoc.pattern.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class GPProxyTest {

  public static void main(String[] args) {
    try {

      // JDK动态代理的实现原理
      Person obj = (Person) new GPMeipo().getInstance(new Girl());
      System.out.println(obj.getClass());
      obj.findLove();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

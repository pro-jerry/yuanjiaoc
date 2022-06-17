package com.yuanjiaoc.pattern.proxy.dynamicproxy.jdkproxy;

import com.yuanjiaoc.pattern.proxy.Person;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Girl implements Person {

  @Override
  public void findLove() {
    System.out.println("高富帅");
    System.out.println("身高180cm");
    System.out.println("有6块腹肌");
  }
}

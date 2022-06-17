package com.yuanjiaoc.pattern.proxy.staticproxy;

import com.yuanjiaoc.pattern.proxy.Person;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Son implements Person {

  @Override
  public void findLove() {
    System.out.println("儿子要求：肤白貌美大长腿");
  }

  public void findJob() {}

  public void eat() {}
}

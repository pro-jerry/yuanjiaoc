package com.yuanjiaoc.pattern.proxy.staticproxy;

import com.yuanjiaoc.pattern.proxy.Person;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Father implements Person {

  private final Son son;

  public Father(Son son) {
    this.son = son;
  }

  @Override
  public void findLove() {
    System.out.println("父亲物色对象");
    this.son.findLove();
    System.out.println("双方父母同意，确立关系");
  }

  public void findJob() {}
}

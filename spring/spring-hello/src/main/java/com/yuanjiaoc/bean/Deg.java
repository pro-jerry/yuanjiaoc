package com.yuanjiaoc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Component
public class Deg {
  private Cat cat;

  @Autowired
  public Deg(Cat cat) {
    this.cat = cat;
    System.out.println("调用了Deg的有参构造方法");
  }

  public Cat getCat() {
    return cat;
  }

  @Autowired
  public void setCat(Cat cat) {
    this.cat = cat;
  }

  @Override
  public String toString() {
    return "Deg{" + "cat=" + cat + '}';
  }
}

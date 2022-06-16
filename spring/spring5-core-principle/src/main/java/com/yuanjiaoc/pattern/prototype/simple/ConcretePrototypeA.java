package com.yuanjiaoc.pattern.prototype.simple;

import java.util.List;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ConcretePrototypeA implements Prototype {

  private int age;
  private String name;
  private List hobbies;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List getHobbies() {
    return hobbies;
  }

  public void setHobbies(List hobbies) {
    this.hobbies = hobbies;
  }

  @Override
  public Prototype clone() {

    ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
    concretePrototypeA.setAge(this.age);
    concretePrototypeA.setName(this.name);
    concretePrototypeA.setHobbies(this.hobbies);
    return concretePrototypeA;
  }
}

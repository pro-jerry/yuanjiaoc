package com.yuanjiaoc.beanpropertyinit;

import lombok.Data;
import lombok.ToString;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月18日
 */
@Data
@ToString
public class User {
  private String name;
  private Integer age;

  public User() {}

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}

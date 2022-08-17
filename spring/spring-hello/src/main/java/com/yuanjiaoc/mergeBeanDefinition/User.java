package com.yuanjiaoc.mergeBeanDefinition;

import lombok.Data;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月17日
 */
@Data
public class User extends SuperUser {

  private String name;

  private Integer age;

  public User() {}

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}

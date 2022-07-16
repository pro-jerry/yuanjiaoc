package com.yuanjiaoc.feature;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月14日
 */
public class User {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + '}';
  }
}

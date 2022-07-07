package com.yuanjiaoc.domain;

/**
 * 公司类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class Company {

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Company{" + "name='" + name + '\'' + '}';
  }
}

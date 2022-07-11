package com.yuanjiaoc.dependency.lookup;

import com.yuanjiaoc.bean.Person;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
@Super
public class SuperPerson extends Person {

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "SuperUser{" + "address='" + address + '\'' + "} " + super.toString();
  }
}

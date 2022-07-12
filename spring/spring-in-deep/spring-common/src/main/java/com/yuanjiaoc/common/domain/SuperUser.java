package com.yuanjiaoc.common.domain;

import com.yuanjiaoc.common.annotation.Super;

/**
 * 超级用户.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月12日
 */
@Super
public class SuperUser extends User {

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

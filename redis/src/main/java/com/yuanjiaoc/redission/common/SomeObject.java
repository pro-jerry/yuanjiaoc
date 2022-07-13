package com.yuanjiaoc.redission.common;

import java.io.Serializable;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月13日
 */
public class SomeObject implements Serializable {

  private String str1;

  private String str2;

  public SomeObject() {}

  public SomeObject(String str1, String str2) {
    this.str1 = str1;
    this.str2 = str2;
  }

  public String getStr1() {
    return str1;
  }

  public void setStr1(String str1) {
    this.str1 = str1;
  }

  public String getStr2() {
    return str2;
  }

  public void setStr2(String str2) {
    this.str2 = str2;
  }
}

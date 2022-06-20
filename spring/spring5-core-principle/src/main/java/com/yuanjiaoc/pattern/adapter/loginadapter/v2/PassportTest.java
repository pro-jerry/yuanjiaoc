package com.yuanjiaoc.pattern.adapter.loginadapter.v2;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class PassportTest {

  public static void main(String[] args) {
    IPassportForThird passportForThird = new PassportForThirdAdapter();
    passportForThird.loginForQQ("");
  }
}

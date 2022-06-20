package com.yuanjiaoc.pattern.decorator.battercake.v2;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class BaseBattercake extends Battercake {

  @Override
  protected String getMsg() {
    return "煎饼";
  }

  @Override
  protected int getPrice() {
    return 5;
  }
}

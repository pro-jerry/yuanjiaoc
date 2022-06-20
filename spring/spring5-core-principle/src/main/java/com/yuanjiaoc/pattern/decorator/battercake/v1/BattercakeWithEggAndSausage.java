package com.yuanjiaoc.pattern.decorator.battercake.v1;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class BattercakeWithEggAndSausage extends Battercake {
  @Override
  protected String getMsg() {
    return super.getMsg() + "+1根香肠";
  }

  @Override
  // 加一个香肠加2块钱
  public int getPrice() {
    return super.getPrice() + 2;
  }
}

package com.yuanjiaoc.pattern.decorator.battercake.v1;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class BattercakeWithEgg extends Battercake {

  @Override
  protected String getMsg() {
    return super.getMsg() + "+1个鸡蛋";
  }

  @Override
  // 加一个鸡蛋加1块钱
  public int getPrice() {
    return super.getPrice() + 1;
  }
}

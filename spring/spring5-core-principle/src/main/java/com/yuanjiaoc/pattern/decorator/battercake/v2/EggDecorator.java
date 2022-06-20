package com.yuanjiaoc.pattern.decorator.battercake.v2;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class EggDecorator extends BattercakeDecorator {

  public EggDecorator(Battercake battercake) {
    super(battercake);
  }

  @Override
  protected void doSomething() {}

  @Override
  protected String getMsg() {
    return super.getMsg() + "+1个鸡蛋";
  }

  @Override
  protected int getPrice() {
    return super.getPrice() + 1;
  }
}

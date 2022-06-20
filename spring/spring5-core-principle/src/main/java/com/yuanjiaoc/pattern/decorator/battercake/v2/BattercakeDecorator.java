package com.yuanjiaoc.pattern.decorator.battercake.v2;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public abstract class BattercakeDecorator extends Battercake {

  // 静态代理，委派
  private final Battercake battercake;

  public BattercakeDecorator(Battercake battercake) {
    this.battercake = battercake;
  }

  protected abstract void doSomething();

  @Override
  protected String getMsg() {
    return battercake.getMsg();
  }

  @Override
  protected int getPrice() {
    return battercake.getPrice();
  }
}

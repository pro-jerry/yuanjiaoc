package com.yuanjiaoc.pattern.strategy.pay.payport;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class JDPay extends Payment {

  @Override
  public String getName() {
    return "京东白条";
  }

  @Override
  protected double queryBalance(String uid) {
    return 500;
  }
}

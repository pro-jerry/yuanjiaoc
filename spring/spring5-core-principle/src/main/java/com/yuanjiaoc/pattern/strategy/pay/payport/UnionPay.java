package com.yuanjiaoc.pattern.strategy.pay.payport;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class UnionPay extends Payment {

  @Override
  public String getName() {
    return "银联支付";
  }

  @Override
  protected double queryBalance(String uid) {
    return 120;
  }
}

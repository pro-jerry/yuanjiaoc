package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * 返现活动.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class CashbackStrategy implements PromotionStrategy {

  @Override
  public void doPromotion() {
    System.out.println("返现促销,返回的金额转到支付宝账号");
  }
}

package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * 优惠券.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class CouponStrategy implements PromotionStrategy {

  @Override
  public void doPromotion() {
    System.out.println("领取优惠券,课程的价格直接减优惠券面值抵扣");
  }
}

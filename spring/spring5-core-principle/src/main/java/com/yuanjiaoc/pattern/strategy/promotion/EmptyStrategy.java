package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * 无优惠.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class EmptyStrategy implements PromotionStrategy {

  @Override
  public void doPromotion() {
    System.out.println("无促销活动");
  }
}

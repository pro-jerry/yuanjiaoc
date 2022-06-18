package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * 拼团优惠.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class GroupbuyStrategy implements PromotionStrategy {

  @Override
  public void doPromotion() {
    System.out.println("拼团，满20人成团，全团享受团购价");
  }
}

package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class PromotionActivity {

  private final PromotionStrategy promotionStrategy;

  public PromotionActivity(PromotionStrategy promotionStrategy) {
    this.promotionStrategy = promotionStrategy;
  }

  public void execute() {
    promotionStrategy.doPromotion();
  }
}

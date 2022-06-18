package com.yuanjiaoc.pattern.strategy.promotion;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class PromotionActivityTest {

  public static void main(String[] args) {
    //    PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
    //    activity618.execute();
    //    PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());
    //    activity1111.execute();
    String promotionKey = "GROUPBUY";
    PromotionActivity promotionActivity =
        new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
    promotionActivity.execute();
  }
}

package com.yuanjiaoc.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class PayStrategy {

  public static final String ALI_PAY = "AliPay";
  public static final String JD_PAY = "JdPay";
  public static final String UNION_PAY = "UnionPay";
  public static final String WECHAT_PAY = "WechatPay";
  public static final String DEFAULT_PAY = ALI_PAY;

  private static final Map<String, Payment> payStrategy = new HashMap<>();

  static {
    payStrategy.put(ALI_PAY, new AliPay());
    payStrategy.put(WECHAT_PAY, new WechatPay());
    payStrategy.put(UNION_PAY, new UnionPay());
    payStrategy.put(JD_PAY, new JDPay());
  }

  public static Payment get(String payKey) {
    if (!payStrategy.containsKey(payKey)) {
      return payStrategy.get(DEFAULT_PAY);
    }
    return payStrategy.get(payKey);
  }
}
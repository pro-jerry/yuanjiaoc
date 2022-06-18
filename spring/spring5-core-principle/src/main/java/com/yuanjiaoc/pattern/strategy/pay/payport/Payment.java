package com.yuanjiaoc.pattern.strategy.pay.payport;

import com.yuanjiaoc.pattern.strategy.pay.MsgResult;

/**
 * 支付渠道.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public abstract class Payment {

  // 支付类型
  public abstract String getName();

  // 查询余额
  protected abstract double queryBalance(String uid);

  public MsgResult pay(String uid, double amount) {

    if (queryBalance(uid) < amount) {
      return new MsgResult(500, "支付失败", "余额不足");
    }
    return new MsgResult(200, "支付成功", "支付金额：" + amount);
  }
}

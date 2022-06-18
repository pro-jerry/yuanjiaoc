package com.yuanjiaoc.pattern.strategy.pay;

import com.yuanjiaoc.pattern.strategy.pay.payport.PayStrategy;
import com.yuanjiaoc.pattern.strategy.pay.payport.Payment;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class Order {

  private final String uid;
  private final String orderId;
  private final double amount;

  public Order(String uid, String orderId, double amount) {
    this.uid = uid;
    this.orderId = orderId;
    this.amount = amount;
  }

  // 完美地解决了switch的过程，不需要在代码逻辑中写switch了
  // 更不需要写if    else if
  public MsgResult pay() {
    return pay(PayStrategy.DEFAULT_PAY);
  }

  public MsgResult pay(String payKey) {
    Payment payment = PayStrategy.get(payKey);
    System.out.println("欢迎使用" + payment.getName());
    System.out.println("本次交易金额为：" + amount + "，开始扣款...");
    return payment.pay(uid, amount);
  }
}

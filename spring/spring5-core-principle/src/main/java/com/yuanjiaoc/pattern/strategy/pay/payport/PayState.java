package com.yuanjiaoc.pattern.strategy.pay.payport;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class PayState {

  private final int code;
  private final Object data;
  private final String msg;

  public PayState(int code, Object data, String msg) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  public String toString() {
    return "支付状态：" + code + "--" + msg + ",交易名称:" + data;
  }
}

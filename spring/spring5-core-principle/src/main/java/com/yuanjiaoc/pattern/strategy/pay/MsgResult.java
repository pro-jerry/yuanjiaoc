package com.yuanjiaoc.pattern.strategy.pay;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月18日
 */
public class MsgResult {
  private final int code;
  private final Object data;
  private final String msg;

  public MsgResult(int code, String msg, Object data) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  public String toString() {
    return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
  }
}

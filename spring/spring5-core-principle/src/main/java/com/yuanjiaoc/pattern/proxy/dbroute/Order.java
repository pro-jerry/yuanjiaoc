package com.yuanjiaoc.pattern.proxy.dbroute;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Order {
  private Object orderInfo;
  // 订单创建时间进行按年分库
  private Long createTime;
  private String id;

  public Object getOrderInfo() {
    return orderInfo;
  }

  public void setOrderInfo(Object orderInfo) {
    this.orderInfo = orderInfo;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}

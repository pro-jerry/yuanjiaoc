package com.yuanjiaoc.pattern.proxy.dbroute;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class OrderDao {

  public int insert(Order order) {
    System.out.println("OrderDao创建Order成功!");
    return 1;
  }
}

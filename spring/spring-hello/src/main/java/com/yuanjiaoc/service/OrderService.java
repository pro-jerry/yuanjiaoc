package com.yuanjiaoc.service;

import com.yuanjiaoc.dao.OrderDao;
import javax.annotation.Resource;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月06日
 */
public class OrderService {

  @Resource private OrderDao orderDao;

  public void setDao(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  public void init() {
    System.out.println("OrderService init...");
  }

  public void query() {
    orderDao.query();
  }
}

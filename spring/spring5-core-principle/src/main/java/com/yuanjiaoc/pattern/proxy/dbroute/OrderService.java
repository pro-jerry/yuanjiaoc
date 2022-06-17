package com.yuanjiaoc.pattern.proxy.dbroute;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class OrderService implements IOrderService {

  private final OrderDao orderDao;

  public OrderService() {
    // 如果使用Spring应该是自动注入的
    // 我们为了使用方便，在构造方法中将orderDao直接初始化了
    this.orderDao = new OrderDao();
  }

  @Override
  public int createOrder(Order order) {
    return orderDao.insert(order);
  }
}

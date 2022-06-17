package com.yuanjiaoc.pattern.proxy.dbroute.proxy;

import com.yuanjiaoc.pattern.proxy.dbroute.IOrderService;
import com.yuanjiaoc.pattern.proxy.dbroute.Order;
import com.yuanjiaoc.pattern.proxy.dbroute.db.DynamicDataSourceEntity;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class OrderServiceStaticProxy implements IOrderService {

  private final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

  private final IOrderService orderService;

  public OrderServiceStaticProxy(IOrderService orderService) {
    this.orderService = orderService;
  }

  @Override
  public int createOrder(Order order) {
    Long time = order.getCreateTime();
    Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
    System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
    DynamicDataSourceEntity.set(dbRouter);

    this.orderService.createOrder(order);
    DynamicDataSourceEntity.restore();

    return 0;
  }
}

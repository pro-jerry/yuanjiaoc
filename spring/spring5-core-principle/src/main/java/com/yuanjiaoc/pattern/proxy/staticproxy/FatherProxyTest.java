package com.yuanjiaoc.pattern.proxy.staticproxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class FatherProxyTest {

  public static void main(String[] args) {

    Father father = new Father(new Son());
    father.findLove();

    // 大家每天都在用的一种静态代理的形式
    // 对数据库进行分库分表
    // ThreadLocal
    // 进行数据源动态切换
  }
}

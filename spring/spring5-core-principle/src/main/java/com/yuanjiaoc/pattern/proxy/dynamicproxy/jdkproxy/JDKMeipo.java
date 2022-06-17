package com.yuanjiaoc.pattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class JDKMeipo implements InvocationHandler {

  private Object target;

  public Object getInstance(Object object) {

    this.target = object;
    Class<?> clazz = target.getClass();
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    Object object = method.invoke(this.target, args);
    after();
    return object;
  }

  private void before() {
    System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
    System.out.println("开始物色");
  }

  private void after() {
    System.out.println("OK的话，准备办事");
  }
}

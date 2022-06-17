package com.yuanjiaoc.pattern.proxy.dynamicproxy.cglibproxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class CGlibMeipo implements MethodInterceptor {

  public Object getInstance(Class<?> clazz) {
    // 相当于Proxy，代理的工具类
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    before();
    Object obj = methodProxy.invoke(o, objects);
    after();
    return obj;
  }

  private void before() {
    System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
    System.out.println("开始物色");
  }

  private void after() {
    System.out.println("OK的话，准备办事");
  }
}

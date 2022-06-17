package com.yuanjiaoc.pattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public interface GPInvocationHandler {

  Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}

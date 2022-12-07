package com.yuanjiaoc.reflect;

import java.lang.reflect.Proxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月02日
 */
public class ProxyFactory {

    public static Object newInstance(Object obj) {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?>[]{Task.class},
                new MyInvokationHandler(obj));
    }
}

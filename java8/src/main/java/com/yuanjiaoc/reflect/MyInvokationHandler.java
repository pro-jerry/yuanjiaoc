package com.yuanjiaoc.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月02日
 */
public class MyInvokationHandler implements InvocationHandler {

    private Object obj;

    public MyInvokationHandler(Object object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (method.getName().contains("get")) {
            System.out.println("...get Method Executing...");
        } else {
            System.out.println("...set Method Executing...");
        }
        result = method.invoke(obj, args);
        return result;
    }
}

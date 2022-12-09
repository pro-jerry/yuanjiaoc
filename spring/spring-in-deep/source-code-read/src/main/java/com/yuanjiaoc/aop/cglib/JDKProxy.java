package com.yuanjiaoc.aop.cglib;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月08日
 */
public class JDKProxy implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object targetObj;


    /**
     * 获取代理对象
     */
    public Object newProxy(Object targetObj) {
        this.targetObj = targetObj;
        Class<?> clazz = targetObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 检查权限
        checkPermissions();
        return method.invoke(targetObj, args);
    }

    private void checkPermissions() {
        System.out.println("检查用户权限 checkPermissions");
    }
}

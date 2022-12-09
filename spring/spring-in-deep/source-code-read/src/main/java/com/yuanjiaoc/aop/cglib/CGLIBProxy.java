package com.yuanjiaoc.aop.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月08日
 */
public class CGLIBProxy implements MethodInterceptor {

    /**
     * 需要代理的目标对象
     */
    private Object targetObj;

    /**
     * 获取代理对象
     */
    public Object newProxy(Object targetObj) {
        this.targetObj = targetObj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 过滤方法
        if ("addUser".equals(method.getName())) {
            checkPermissions();
        }

        return method.invoke(targetObj, args);
    }

    private void checkPermissions() {
        System.out.println("检查用户权限 checkPermissions");
    }
}

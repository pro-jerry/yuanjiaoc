package com.yuanjiaoc.cglib;


import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月19日
 */
public class DaoProxy implements MethodInterceptor {

    /**
     * @param object      表示要进行增强的对象
     * @param method      拦截的方法
     * @param objects     参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy 对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("Before Method Invoke");
        methodProxy.invokeSuper(object, objects);
        System.out.println("After Method Invoke");
        return object;
    }
}

package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("我是MethodInterceptor start");
        //调用invocation.proceed()执行下一个拦截器
        Object result = invocation.proceed();
        System.out.println("我是MethodInterceptor end");
        //返回结果
        return result;
    }
}

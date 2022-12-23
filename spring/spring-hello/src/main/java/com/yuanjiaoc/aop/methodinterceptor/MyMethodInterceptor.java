package com.yuanjiaoc.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MyMethodInterceptor  " + methodInvocation.getMethod().getName());
        return methodInvocation.proceed();
    }
}

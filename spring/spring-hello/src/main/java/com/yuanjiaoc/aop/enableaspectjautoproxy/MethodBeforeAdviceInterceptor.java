package com.yuanjiaoc.aop.enableaspectjautoproxy;

import java.io.Serializable;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor, BeforeAdvice, Serializable {

    private final MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //调用MethodBeforeAdvice的before方法，执行前置通知
        this.advice.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        //执行下一个拦截器
        return mi.proceed();
    }
}

package com.yuanjiaoc.aop.enableaspectjautoproxy;

import java.io.Serializable;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class AfterReturningAdviceInterceptor implements MethodInterceptor, AfterAdvice, Serializable {

    private final AfterReturningAdvice advice;

    public AfterReturningAdviceInterceptor(AfterReturningAdvice advice) {
        this.advice = advice;
    }


    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        //执行下一个拦截器，可以获取目标方法的返回结果
        Object retVal = mi.proceed();
        //调用方法返回通知的afterReturning方法，会传入目标方法的返回值等信息
        this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
        return retVal;
    }
}

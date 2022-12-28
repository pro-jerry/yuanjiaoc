package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class ThrowsAdviceInterceptor implements MethodInterceptor, AfterAdvice {

    private final Object throwsAdvice;

    public ThrowsAdviceInterceptor(Object throwsAdvice) {
        this.throwsAdvice = throwsAdvice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable ex) {
            //调用 ThrowsAdvice 中的 afterThrowing 方法来处理异常
            //将异常继续往外抛
            throw ex;
        }
    }
}

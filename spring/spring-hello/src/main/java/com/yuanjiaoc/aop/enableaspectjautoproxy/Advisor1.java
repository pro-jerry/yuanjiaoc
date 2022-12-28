package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
//@Component
public class Advisor1 extends DefaultPointcutAdvisor {

    public Advisor1() {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("Advisor1 start");
                Object result = invocation.proceed();
                System.out.println("Advisor1 end");
                return result;
            }
        };
        this.setAdvice(methodInterceptor);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

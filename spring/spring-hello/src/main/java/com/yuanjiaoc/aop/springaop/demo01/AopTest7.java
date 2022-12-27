package com.yuanjiaoc.aop.springaop.demo01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class AopTest7 {

    @Test
    public void test1() {
        Service00 target = new Service00();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.setExposeProxy(true);

        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                long startTime = System.nanoTime();
                Object result = invocation.proceed();
                long endTime = System.nanoTime();
                System.out.println(
                        String.format("%s方法耗时(纳秒):%s",
                                invocation.getMethod().getName(),
                                endTime - startTime));
                return result;
            }
        });

        Service00 proxy = (Service00) proxyFactory.getProxy();
        proxy.m1();
    }
}

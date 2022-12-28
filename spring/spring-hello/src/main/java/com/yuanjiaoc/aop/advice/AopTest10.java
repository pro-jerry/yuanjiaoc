package com.yuanjiaoc.aop.advice;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class AopTest10 {

    @Test
    public void test1() {
        Service1 target = new Service1();
        Class<BeforeAspect> aspectClass = BeforeAspect.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("路人"));
        System.out.println(proxy.work("路人"));
    }

    @Test
    public void test2() {
        Service1 target = new Service1();
        Class<BeforeAspect2> aspectClass = BeforeAspect2.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("路人"));
        System.out.println(proxy.work("路人"));
    }

    @Test
    public void test3() {
        Service1 target = new Service1();
        Class<AroundAspect3> aspectClass = AroundAspect3.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("路人"));
        System.out.println(proxy.work("路人"));
    }

    @Test
    public void test4() {
        Service1 target = new Service1();
        Class<AfterAspect4> aspectClass = AfterAspect4.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        System.out.println(proxy.say("路人"));
        System.out.println(proxy.work("路人"));
    }

    @Test
    public void test6() {
        Service1 target = new Service1();
        Class<AfterThrowingAspect6> aspectClass = AfterThrowingAspect6.class;
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(aspectClass);
        Service1 proxy = proxyFactory.getProxy();
        proxy.login("路人");
    }
}

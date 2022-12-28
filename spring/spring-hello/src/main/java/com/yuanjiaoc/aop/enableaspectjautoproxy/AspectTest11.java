package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class AspectTest11 {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        UserService userService = context.getBean(UserService.class);
        userService.say();
        CarService carService = context.getBean(CarService.class);
        carService.say();
    }

    @Test
    public void test3() {
        //创建目标对象
        MoreAdvice.Service3 target = new MoreAdvice.Service3();
        //创建代理工厂，通过代理工厂来创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        //依次为目标对象添加4种通知
        proxyFactory.addAdvice(new MoreAdvice.MyMethodInterceptor());
        proxyFactory.addAdvice(new MoreAdvice.MyMethodBeforeAdvice());
        proxyFactory.addAdvice(new MoreAdvice.MyAfterReturningAdvice());
        proxyFactory.addAdvice(new MoreAdvice.MyThrowsAdvice());
        //获取到代理对象
        MoreAdvice.Service3 proxy = (MoreAdvice.Service3) proxyFactory.getProxy();
        //通过代理对象访问目标方法say
        System.out.println(proxy.say("路人"));
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig4.class);
        context.refresh();
        Service4 service4 = context.getBean(Service4.class);
        System.out.println(service4.say("路人"));
    }
}

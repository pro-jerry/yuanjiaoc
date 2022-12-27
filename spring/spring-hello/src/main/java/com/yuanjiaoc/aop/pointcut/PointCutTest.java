package com.yuanjiaoc.aop.pointcut;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.ClassUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class PointCutTest {

    @Test
    public void test2() {
        C2 target = new C2();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest2.class);

        C2 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    @Test
    public void test3() {
        Service3 target = new Service3();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        //获取目标对象上的接口列表
        Class<?>[] allInterfaces = ClassUtils.getAllInterfaces(target);
        //设置需要代理的接口
        proxyFactory.setInterfaces(allInterfaces);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAspect(AspectTest3.class);
        //获取代理对象
        Object proxy = proxyFactory.getProxy();
        //调用代理对象的方法
        ((I1) proxy).m1();
        System.out.println("proxy是否是jdk动态代理对象：" + AopUtils.isJdkDynamicProxy(proxy));
        System.out.println("proxy是否是cglib代理对象：" + AopUtils.isCglibProxy(proxy));
        //判断代理对象是否是Service3类型的
        System.out.println(Service3.class.isAssignableFrom(proxy.getClass()));
    }

    @Test
    public void test4() {
        Service3 target = new Service3();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest4.class);
        //获取代理对象
        Object proxy = proxyFactory.getProxy();
        //调用代理对象的方法
        ((I1) proxy).m1();
        //判断target对象是否是Service3类型的
        System.out.println(Service3.class.isAssignableFrom(target.getClass()));
    }

    @Test
    public void test5() {
        Service5 target = new Service5();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest5.class);
        Service5 proxy = proxyFactory.getProxy();
        proxy.m1("路人");
        proxy.m1(100);
    }

    @Test
    public void test9() {
        S9 target = new S9();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest9.class);
        S9 proxy = proxyFactory.getProxy();
        proxy.m1();
    }

    @Test
    public void test10() {
        S10 target = new S10();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest10.class);
        S10 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    @Test
    public void test11() {
        S11 target = new S11();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest11.class);
        S11 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }

    @Test
    public void test7() {
        S7 target = new S7();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest7.class);
        S7 proxy = proxyFactory.getProxy();
        proxy.m1();
        System.out.println("目标类上是否有 @Ann7 注解：" + (target.getClass().getAnnotation(Ann7.class) != null));
    }

    @Test
    public void test12() {
        S12 target = new S12();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AspectTest12.class);
        S12 proxy = proxyFactory.getProxy();
        proxy.m1();
        proxy.m2();
        proxy.m3();
        proxy.m4();
    }
}

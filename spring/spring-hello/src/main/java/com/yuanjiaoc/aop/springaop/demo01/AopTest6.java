package com.yuanjiaoc.aop.springaop.demo01;

import com.sun.istack.internal.Nullable;
import java.lang.reflect.Method;
import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class AopTest6 {

    @Test
    public void test1() {
        Service target = new Service();

        ProxyFactory proxyFactory = new ProxyFactory();
        //设置需要被代理的对象
        proxyFactory.setTarget(target);
        //设置需要代理的接口
        proxyFactory.addInterface(IService.class);

        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                System.out.println(method);
            }
        });

        IService proxy = (IService) proxyFactory.getProxy();
        System.out.println("代理对象的类型：" + proxy.getClass());
        System.out.println("代理对象的父类：" + proxy.getClass().getSuperclass());
        System.out.println("代理对象实现的接口列表:");
        for (Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }
        //调用代理的方法
        System.out.println("\n调用代理的方法");
        proxy.say("spring aop");
    }
}

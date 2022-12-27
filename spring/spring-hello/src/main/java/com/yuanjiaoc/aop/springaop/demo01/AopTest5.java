package com.yuanjiaoc.aop.springaop.demo01;

import com.sun.istack.internal.Nullable;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class AopTest5 {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new FundsService());
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                System.out.println(method);
            }
        }));
        //创建代理对象
        Object proxy = proxyFactory.getProxy();
        System.out.println("代理对象的类型：" + proxy.getClass());
        System.out.println("代理对象的父类：" + proxy.getClass().getSuperclass());
        System.out.println("代理对象实现的接口列表:");
        for (Class<?> cf : proxy.getClass().getInterfaces()) {
            System.out.println(cf);
        }
    }
}

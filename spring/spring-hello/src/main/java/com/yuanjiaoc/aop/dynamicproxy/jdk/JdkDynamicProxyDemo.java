package com.yuanjiaoc.aop.dynamicproxy.jdk;

import com.yuanjiaoc.aop.staticproxy.demo01.DefaultEchoService;
import com.yuanjiaoc.aop.staticproxy.demo01.EchoService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        // 当前线程的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    // 被代理对象
                    EchoService echoService = new DefaultEchoService();
                    long startTime = System.currentTimeMillis();
                    String result = echoService.echo((String) args[0]);
                    long costTime = System.currentTimeMillis() - startTime;
                    System.out.println("echo 方法执行的实现：" + costTime + " ms.");
                    return result;
                }
                return null;
            }
        });
        EchoService echoService = (EchoService) proxy;
        System.out.println("-------------------");
        echoService.echo("Hello,World");
    }
}

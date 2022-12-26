package com.yuanjiaoc.aop.dynamicproxy.cglib;

import com.yuanjiaoc.aop.staticproxy.demo01.DefaultEchoService;
import com.yuanjiaoc.aop.staticproxy.demo01.EchoService;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月24日
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        // 创建 CGLIB 增强对象
        Enhancer enhancer = new Enhancer();
        // 指定父类，也就是被代理的类
        Class<?> superClass = DefaultEchoService.class;
        enhancer.setSuperclass(superClass);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                long startTime = System.currentTimeMillis();
                Object result = methodProxy.invokeSuper(source, args);
                long costTime = System.currentTimeMillis() - startTime;
                System.out.println("[CGLIB 字节码提升] echo 方法执行的实现：" + costTime + " ms.");
                return result;
            }
        });
        // 创建代理对象
        EchoService echoService = (EchoService) enhancer.create();
        // 输出执行结果
        System.out.println(echoService.echo("Hello,World"));

    }
}

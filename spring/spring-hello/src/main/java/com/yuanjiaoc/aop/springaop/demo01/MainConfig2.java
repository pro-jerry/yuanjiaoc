package com.yuanjiaoc.aop.springaop.demo01;

import com.sun.istack.internal.Nullable;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Configuration
public class MainConfig2 {

    //注册目标对象
    @Bean
    public Service1 service1() {
        return new Service1();
    }

    //定义一个增强器：interceptor1，内部是一个前置通知，需要将其包装为Advisor类型的
    @Bean
    public Advisor interceptor1() {
        MethodBeforeAdvice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
                System.out.println("准备调用：" + method);
            }
        };
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(advice);
        return advisor;
    }

    //定义一个增强器：interceptor2
    @Bean
    public MethodInterceptor interceptor2() {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                long starTime = System.nanoTime();
                Object result = invocation.proceed();
                long endTime = System.nanoTime();
                System.out.println(invocation.getMethod() + ",耗时(纳秒)：" + (endTime - starTime));
                return result;
            }
        };
        return methodInterceptor;
    }

    //注册ProxyFactoryBean
    @Bean
    public ProxyFactoryBean service1Proxy() {
        //1.创建ProxyFactoryBean
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //2.设置目标对象的bean名称
        proxyFactoryBean.setTargetName("service1");
        //3.设置拦截器的bean名称列表，此处批量注册
        proxyFactoryBean.setInterceptorNames("interceptor*"); //@1
        return proxyFactoryBean;
    }
}

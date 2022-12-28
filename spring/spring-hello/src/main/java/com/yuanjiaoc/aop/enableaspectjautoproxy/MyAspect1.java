package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Aspect
@Order(1)
@Component
public class MyAspect1 {

    @Pointcut("execution(* com.yuanjiaoc.aop.enableaspectjautoproxy.Service2.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before() {
        System.out.println("MyAspect1 @Before通知!");
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect1 @Around通知start");
        Object result = joinPoint.proceed();
        System.out.println("MyAspect1 @Around绕通知end");
        return result;
    }

    @After("pc()")
    public void after() throws Throwable {
        System.out.println("MyAspect1 @After通知!");
    }

    @AfterReturning("pc()")
    public void afterReturning() throws Throwable {
        System.out.println("MyAspect1 @AfterReturning通知!");
    }

    @AfterThrowing("pc()")
    public void afterThrowing() {
        System.out.println("MyAspect1 @AfterThrowing通知!");
    }

}

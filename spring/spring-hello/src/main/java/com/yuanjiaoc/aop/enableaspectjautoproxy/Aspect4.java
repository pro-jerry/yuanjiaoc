package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Component
@Aspect
public class Aspect4 {

    @Pointcut("execution(* com.yuanjiaoc.aop.enableaspectjautoproxy.Service4.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before() {
        System.out.println("@Before通知!");
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around通知start");
        Object result = joinPoint.proceed();
        System.out.println("@Around绕通知end");
        return result;
    }

    @After("pc()")
    public void after() throws Throwable {
        System.out.println("@After通知!");
    }

    @AfterReturning("pc()")
    public void afterReturning() throws Throwable {
        System.out.println("@AfterReturning通知!");
    }

    @AfterThrowing("pc()")
    public void afterThrowing() {
        System.out.println("@AfterThrowing通知!");
    }
}

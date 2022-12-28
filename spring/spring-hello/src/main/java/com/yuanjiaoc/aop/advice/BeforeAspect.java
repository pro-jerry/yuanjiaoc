package com.yuanjiaoc.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Aspect
public class BeforeAspect {

    @Pointcut("execution(* com.yuanjiaoc.aop.advice.Service1.*(..))")
    public void pc() {
    }

    @Before("com.yuanjiaoc.aop.advice.BeforeAspect.pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知!");
    }
}

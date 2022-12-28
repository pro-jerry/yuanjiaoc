package com.yuanjiaoc.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Aspect
public class AfterAspect4 {

    @Pointcut("execution(* com.yuanjiaoc.aop.advice.Service1.*(..))")
    public void pc() {
    }

    @After("com.yuanjiaoc.aop.advice.AfterAspect4.pc()")
    public void after(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(String.format("%s,执行完毕!", methodSignature.getMethod()));
    }
}

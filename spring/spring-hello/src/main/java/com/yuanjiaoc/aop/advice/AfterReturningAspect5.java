package com.yuanjiaoc.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Aspect
public class AfterReturningAspect5 {

    @Pointcut("execution(* com.yuanjiaoc.aop.advice.Service1.*(..))")
    public void pc() {
    }

    @AfterReturning(value = "com.yuanjiaoc.aop.advice.AfterReturningAspect5.pc()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, Object retVal) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(String.format("%s返回值：%s", methodSignature.getMethod(), retVal));
    }
}

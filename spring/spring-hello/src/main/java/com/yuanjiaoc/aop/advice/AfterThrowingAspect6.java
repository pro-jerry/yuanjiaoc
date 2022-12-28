package com.yuanjiaoc.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Aspect
public class AfterThrowingAspect6 {

    @Pointcut("execution(* com.yuanjiaoc.aop.advice.Service1.*(..))")
    public void pc() {
    }

    @AfterThrowing(value = "com.yuanjiaoc.aop.advice.AfterThrowingAspect6.pc()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(String.format("%s发生异常,异常信息：%s", methodSignature.getMethod(), e.getMessage()));
    }
}

package com.yuanjiaoc.aop.example01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Aspect
@Component
public class BuyAspectJ {

    /*
    @Before("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..))")
    public void hehe() {
        System.out.println("Before ...");
    }

    @After("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..))")
    public void haha() {
        System.out.println("After ...");
    }

    @AfterReturning("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..))")
    public void xixi() {
        System.out.println("AfterReturning ...");
    }

    @Around("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..))")
    public void xxx(ProceedingJoinPoint pj) {
        try {
            System.out.println("Around aaa ...");
            pj.proceed();
            System.out.println("Around bbb ...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    
     */
    @Pointcut("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..))")
    public void point() {
    }

    @Before("point()")
    public void hehe() {
        System.out.println("before ...");
    }

    @After("point()")
    public void haha() {
        System.out.println("After ...");
    }

    @AfterReturning("point()")
    public void xixi() {
        System.out.println("AfterReturning ...");
    }

    @Around("point()")
    public void xxx(ProceedingJoinPoint pj) {
        try {
            System.out.println("Around aaa ...");
            pj.proceed();
            System.out.println("Around bbb ...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}

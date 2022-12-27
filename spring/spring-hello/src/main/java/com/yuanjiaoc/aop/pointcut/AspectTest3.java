package com.yuanjiaoc.aop.pointcut;

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
public class AspectTest3 {

    //@1：匹配proxy是Service3类型的所有方法
    @Pointcut("this(Service3)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinpoint) {
        System.out.println(joinpoint);
    }
}

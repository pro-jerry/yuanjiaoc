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
public class AspectTest4 {

    //@1：目标类型必须是Service3类型的
    @Pointcut("target(com.yuanjiaoc.aop.pointcut.Service3)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinpoint) {
        System.out.println(joinpoint);
    }
}

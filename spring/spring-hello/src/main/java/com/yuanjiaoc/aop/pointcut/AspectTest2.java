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
public class AspectTest2 {

    @Pointcut("within(C1+)") //@1
    public void pc() {
    }

    @Before("pc()") //@2
    public void beforeAdvice(JoinPoint joinpoint) {
        System.out.println(joinpoint);
    }
}

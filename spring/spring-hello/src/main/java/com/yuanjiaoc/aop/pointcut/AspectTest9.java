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
public class AspectTest9 {

    /**
     * 定义目标方法的类上有Ann9注解
     */
    @Pointcut("@within(Ann9)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }
}

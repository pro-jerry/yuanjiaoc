package com.yuanjiaoc.aop.pointcut;

import java.util.Arrays;
import java.util.stream.Collectors;
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
public class AspectTest5 {

    //@1：匹配只有1个参数其类型是String类型的
    @Pointcut("args(String)")
    public void pc() {
    }

    @Before("pc()")
    public void beforeAdvice(JoinPoint joinpoint) {
        System.out.println("请求参数：" + Arrays.stream(joinpoint.getArgs()).collect(Collectors.toList()));
    }
}

package com.yuanjiaoc.aop.advice;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
@Aspect
public class BeforeAspect2 {

    @Pointcut("execution(* com.yuanjiaoc.aop.advice.Service1.*(..))")
    public void pc() {
    }

    @Before("com.yuanjiaoc.aop.advice.BeforeAspect2.pc()")
    public void before(JoinPoint joinPoint) {
        //获取连接点签名
        Signature signature = joinPoint.getSignature();
        //将其转换为方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        //通过方法签名获取被调用的目标方法
        Method method = methodSignature.getMethod();
        //输出方法信息
        System.out.println(method);
    }
}

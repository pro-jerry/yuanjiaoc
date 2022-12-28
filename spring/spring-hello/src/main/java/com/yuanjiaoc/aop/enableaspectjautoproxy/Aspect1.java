package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Component //@1
@Aspect //@2
public class Aspect1 {

    @Pointcut("execution(* com.yuanjiaoc.aop.enableaspectjautoproxy..*(..))") //@3
    public void pc() {
    }

    @Before("com.yuanjiaoc.aop.enableaspectjautoproxy.Aspect1.pc()") //@4
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知,target:" + joinPoint.getTarget()); //5
    }
}

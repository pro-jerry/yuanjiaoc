package com.yuanjiaoc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月04日
 */
@Aspect
@Component
public class MyAspect {

  @Around("@annotation(com.yuanjiaoc.aop.MyAnnotation)")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("around... invoke ...");
    return pjp.proceed();
  }

  @Around("@args(com.yuanjiaoc.aop.MyAnnotation)")
  public Object around0(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("around..args. invoke ...");
    return pjp.proceed();
  }
}

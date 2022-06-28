package com.yuanjiaoc.aspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 打印日志的切面类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Aspect
public class LogAspect {
  @Pointcut("execution(public int com.yuanjiaoc.aop.MathHandler.*(..))")
  public void pointCut() {}

  @Before("pointCut()")
  public void logStart(JoinPoint joinPoint) {
    System.out.println(
        joinPoint.getSignature().getName()
            + " 运行开始，参数列表是：{"
            + Arrays.asList(joinPoint.getArgs())
            + "}");
  }

  @After("pointCut()")
  public void logEnd(JoinPoint joinPoint) {
    System.out.println(joinPoint.getSignature().getName() + " 运行结束");
  }

  @AfterReturning(value = "pointCut()", returning = "result")
  public void logReturn(JoinPoint joinPoint, Object result) {
    System.out.println(joinPoint.getSignature().getName() + " 正常返回，运行结果：{" + result + "}");
  }

  @AfterThrowing(value = "pointCut()", throwing = "exception")
  public void logException(JoinPoint joinPoint, Exception exception) {
    System.out.println(joinPoint.getSignature().getName() + " 异常，异常信息：{" + exception + "}");
  }
}

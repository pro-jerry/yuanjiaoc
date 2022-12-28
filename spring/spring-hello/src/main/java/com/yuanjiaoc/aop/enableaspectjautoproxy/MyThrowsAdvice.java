package com.yuanjiaoc.aop.enableaspectjautoproxy;

import java.lang.reflect.Method;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("我是ThrowsAdvice");
    }
}

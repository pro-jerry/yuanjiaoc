package com.yuanjiaoc.aop.enableaspectjautoproxy;

import com.sun.istack.internal.Nullable;
import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target)
            throws Throwable {
        System.out.println("我是AfterReturningAdvice");
    }
}

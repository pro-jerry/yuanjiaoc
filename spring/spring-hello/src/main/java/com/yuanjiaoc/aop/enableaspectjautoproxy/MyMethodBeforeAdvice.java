package com.yuanjiaoc.aop.enableaspectjautoproxy;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是MethodBeforeAdvice");
    }
}

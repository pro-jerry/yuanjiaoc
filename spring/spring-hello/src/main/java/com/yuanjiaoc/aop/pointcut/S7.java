package com.yuanjiaoc.aop.pointcut;

import java.lang.annotation.Target;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class S7 extends S7Parent {

    public void m1() {
        System.out.println("我是m1");
    }

    public static void main(String[] args) {
        System.out.println(S7.class.getAnnotation(Target.class));
    }
}

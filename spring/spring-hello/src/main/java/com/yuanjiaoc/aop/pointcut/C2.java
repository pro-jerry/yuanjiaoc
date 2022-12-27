package com.yuanjiaoc.aop.pointcut;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class C2 extends C1 {

    @Override
    public void m2() {
        super.m2();
    }

    public void m3() {
        System.out.println("我是m3");
    }
}

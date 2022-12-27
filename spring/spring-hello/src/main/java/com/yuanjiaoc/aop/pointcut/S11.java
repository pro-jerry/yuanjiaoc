package com.yuanjiaoc.aop.pointcut;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class S11 extends S11Parent {

    @Override
    public void m2() {
        System.out.println("我是S11.m2()方法");
    }

    public void m3() {
        System.out.println("我是S11.m3()方法");
    }
}

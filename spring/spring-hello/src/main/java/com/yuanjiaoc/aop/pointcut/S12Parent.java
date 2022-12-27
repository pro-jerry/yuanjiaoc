package com.yuanjiaoc.aop.pointcut;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class S12Parent {

    @Ann12
    public void m1() {
        System.out.println("我是S12Parent.m1()方法");
    }

    @Ann12
    public void m2() {
        System.out.println("我是S12Parent.m2()方法");
    }
}

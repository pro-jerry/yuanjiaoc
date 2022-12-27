package com.yuanjiaoc.aop.aspect;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class Service1 {

    public void m1() {
        System.out.println("我是 m1 方法");
    }

    public void m2() {
        System.out.println(10 / 0);
        System.out.println("我是 m2 方法");
    }
}

package com.yuanjiaoc.aop.springaop.demo01;

import org.springframework.aop.framework.AopContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class Service00 {

    public void m1() {
        System.out.println("m1");
//        this.m2();
        ((Service00) AopContext.currentProxy()).m2();
    }

    public void m2() {
        System.out.println("m2");
    }
}

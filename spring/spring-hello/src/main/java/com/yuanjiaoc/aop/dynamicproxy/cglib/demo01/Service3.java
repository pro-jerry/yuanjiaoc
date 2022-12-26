package com.yuanjiaoc.aop.dynamicproxy.cglib.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
public class Service3 {

    public String m1() {
        System.out.println("我是m1方法");
        return "hello:m1";
    }

    public String m2() {
        System.out.println("我是m2方法");
        return "hello:m2";
    }
}

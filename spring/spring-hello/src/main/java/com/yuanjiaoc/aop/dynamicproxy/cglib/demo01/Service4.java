package com.yuanjiaoc.aop.dynamicproxy.cglib.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
public class Service4 {

    public void insert1() {
        System.out.println("我是insert1");
    }

    public void insert2() {
        System.out.println("我是insert2");
    }

    public String get1() {
        System.out.println("我是get1");
        return "get1";
    }

    public String get2() {
        System.out.println("我是get2");
        return "get2";
    }
}

package com.yuanjiaoc.aop.staticproxy.demo03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
public class ServiceB implements IService {

    @Override
    public void m1() {
        System.out.println("我是ServiceB中的m1方法!");
    }

    @Override
    public void m2() {
        System.out.println("我是ServiceB中的m2方法!");
    }

    @Override
    public void m3() {
        System.out.println("我是ServiceB中的m3方法!");
    }
}

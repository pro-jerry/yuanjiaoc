package com.yuanjiaoc.aop.springaop.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class Service implements IService {

    @Override
    public void say(String name) {
        System.out.println("hello：" + name);
    }
}

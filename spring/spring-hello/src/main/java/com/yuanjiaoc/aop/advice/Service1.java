package com.yuanjiaoc.aop.advice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月27日
 */
public class Service1 {

    public String say(String name) {
        return "你好：" + name;
    }

    public String work(String name) {
        return "开始工作了：" + name;
    }

    public boolean login(String name) {
        if (!"路人甲java".equals(name)) {
            throw new IllegalArgumentException("非法访问!");
        }
        return true;
    }
}

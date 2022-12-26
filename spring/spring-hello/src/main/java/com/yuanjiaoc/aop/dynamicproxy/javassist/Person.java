package com.yuanjiaoc.aop.dynamicproxy.javassist;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月24日
 */
public class Person {

    private String name = "jingping";

    public void setName(String var1) {
        this.name = var1;
    }

    public String getName() {
        return this.name;
    }

    public Person() {
        this.name = "liujingping";
    }

    public void say() {
        System.out.println("say: hello, " + this.name);
    }
}

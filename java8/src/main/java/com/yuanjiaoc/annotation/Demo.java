package com.yuanjiaoc.annotation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月28日
 */
@MyAnnotaion(getValue = "annotation on class")
public class Demo {

    @MyAnnotaion(getValue = "annotation on filed")
    public String name;

    @MyAnnotaion(getValue = "annotation on method")
    public void hello() {
    }

    @MyAnnotaion
    public void defaultMethod() {

    }
}

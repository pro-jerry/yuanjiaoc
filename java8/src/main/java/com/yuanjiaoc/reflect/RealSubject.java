package com.yuanjiaoc.reflect;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月01日
 */
public class RealSubject implements Subject {

    @Override
    public void hello(String str) {
        System.out.println("Hello  " + str);
    }

    @Override
    public String bye() {
        System.out.println("Goodbye");
        return "Over";
    }
}

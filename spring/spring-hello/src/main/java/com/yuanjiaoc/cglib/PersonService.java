package com.yuanjiaoc.cglib;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月20日
 */
public class PersonService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}

package com.yuanjiaoc.annotation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月27日
 */
public class User {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    @Init("louis")
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    @Init("22")
    public User setAge(String age) {
        this.age = age;
        return this;
    }
}

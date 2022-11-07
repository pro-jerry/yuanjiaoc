package com.yuanjiaoc.sourcecoderead.invoke;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月26日
 */
@Data
@MyAnnotation(value = "scope")
public class Person extends Creature<String> implements Cloneable, Serializable {

    public int id;
    private int age;
    private String name;

    public Person() {
        System.out.println("构造器");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @MyAnnotation(value = "show")
    public void show() {
        System.out.println("person class show");
    }
}

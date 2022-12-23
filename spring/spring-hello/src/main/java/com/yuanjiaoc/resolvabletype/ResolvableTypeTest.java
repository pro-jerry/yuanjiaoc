package com.yuanjiaoc.resolvabletype;

import java.lang.reflect.Field;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月22日
 */
public class ResolvableTypeTest {

    private String service;

    public static void main(String[] args) {

        forClassTest();
        System.out.println("---------------");
        forFieldTest();
    }

    public static void forFieldTest() {
        Field field = ReflectionUtils.findField(ResolvableTypeTest.class, "service");
        ResolvableType resolvableType = ResolvableType.forField(field);
        System.out.println(resolvableType.getType());
        System.out.println(resolvableType.resolve());
    }

    public static void forClassTest() {
        ResolvableType resolvableType = ResolvableType.forClass(ServiceImpl.class);
        System.out.println(resolvableType.getType());
        System.out.println(resolvableType.resolve());
    }
}

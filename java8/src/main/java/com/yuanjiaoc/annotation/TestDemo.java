package com.yuanjiaoc.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月28日
 */
public class TestDemo {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        /**
         * 获取类上的注解
         */
        Class<Demo> demoClass = Demo.class;
        Annotation[] annotaion = demoClass.getAnnotations();
        printAnnotation(annotaion);

        /**
         * 读取成员变量上的注解
         */
        Field name = demoClass.getField("name");
        Annotation[] getOnFiled = name.getAnnotations();
        printAnnotation(getOnFiled);

        /**
         * 读取方法上的注解
         */
        Method hello = demoClass.getMethod("hello", null);
        MyAnnotaion onMethod = hello.getAnnotation(MyAnnotaion.class);
        System.out.println(onMethod.getValue());

        /**
         * 获取默认方法上的注解
         */
        Method defaultMethod = demoClass.getMethod("defaultMethod", null);
        MyAnnotaion onDefaultMethod = defaultMethod.getAnnotation(MyAnnotaion.class);
        System.out.println(onDefaultMethod.getValue());
    }

    public static void printAnnotation(Annotation... annotations) {
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

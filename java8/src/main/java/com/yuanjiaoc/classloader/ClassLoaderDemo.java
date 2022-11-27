package com.yuanjiaoc.classloader;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月27日
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        System.out.println("ClassLoader is:" + cl.toString());
        System.out.println("ClassLoader's parent is:" + cl.getParent().toString());
        System.out.println("ClassLoader's grand father is:" + cl.getParent().getParent().toString());

    }
}

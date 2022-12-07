package com.yuanjiaoc.reflect;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月02日
 */
public class Test {

    public static void main(String[] args) {
        Task task = (Task) ProxyFactory.newInstance(new TaskImpl());
        task.setData("Test");
        System.out.println("============");
        System.out.println(task.getCalData(5));
    }
}

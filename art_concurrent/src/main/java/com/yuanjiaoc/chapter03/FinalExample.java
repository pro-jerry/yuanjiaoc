package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月22日
 */
public class FinalExample {

    int i; // 普通变量
    final int j; // final变量
    static FinalExample obj;

    // 构造函数
    public FinalExample () {
        // 写普通域
        i = 1;
        // 写final域
        j = 2;
    }

    // 写线程A执行
    public static void writer (){
        obj = new FinalExample ();
    }

    // 读线程B执行
    public static void reader (){
        FinalExample object = obj; // 读对象引用
        int a = object.i; // 读普通域
        int b = object.j; // 读final域
    }
}

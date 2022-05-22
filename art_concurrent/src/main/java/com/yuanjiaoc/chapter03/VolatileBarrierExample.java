package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月21日
 * 3.4.4 volatile内存语义的实现
 */
public class VolatileBarrierExample {

    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite(){
        int i = v1; // 第一个volatile读
        int j = v2; // 第二个volatile读
        a = i + j; // 普通写
        v1 = i + 1; // 第一个volatile写
        v2 = j * 2; // 第二个 volatile写
    }
}

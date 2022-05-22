package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月21日
 * 3.4.2 volatile写-读建立的happens-before关系
 */
public class VolatileExample {

    int a = 0;
    volatile boolean flag = false;
    public void writer(){
        a = 1; // 1
        flag = true; // 2
    }

    public void reader(){
        if (flag){      //3
            int i = a; // 4
        }
    }
}

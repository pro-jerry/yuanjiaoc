package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月21日
 */
public class VolatileFeaturesExample {

    // 使用volatile声明64位的long型变量
    volatile long vl = 0L;

    // 单个volatile变量的写
    public void set(long l) {
        vl = l;
    }

    // 复合（多个）volatile变量的读/写
    public void getAndIncrement (){
        vl++;
    }

    // 单个volatile变量的读
    public long get(){
        return vl;
    }
}

package com.yuanjiaoc.chapter03;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月21日
 *
 * 3.4.1 volatile的特性
 */
public class VolatileFeaturesExample1 {

    // 64位的long型普通变量
    long vl = 0L;

    // 对单个的普通变量的写用同一个锁同步
    public synchronized void set(long l){
        vl = l;
    }

    // 普通方法调用
    public void getAndIncrement() {
        // 调用已同步的读方法
        long temp = get();
        // 普通写操作
        temp += 1L;
        // 调用已同步的写方法
        set(temp);
    }

    // 对单个的普通变量的读用同一个锁同步
    public synchronized long get(){
        return vl;
    }
}

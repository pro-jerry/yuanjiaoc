package com.yuanjiaoc.chapter07;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}

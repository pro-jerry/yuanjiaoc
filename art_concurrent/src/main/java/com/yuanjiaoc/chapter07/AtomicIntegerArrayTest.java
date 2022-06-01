package com.yuanjiaoc.chapter07;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class AtomicIntegerArrayTest {

    static int[]              value = new int[] { 1, 2 };
    static AtomicIntegerArray ai    = new AtomicIntegerArray(value);

  public static void main(String[] args) {

      ai.getAndSet(0, 3);
      System.out.println(ai.get(0));
      System.out.println(value[0]);
  }
}

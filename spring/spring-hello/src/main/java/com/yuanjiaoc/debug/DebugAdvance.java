package com.yuanjiaoc.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月25日
 */
public class DebugAdvance {

  public static void advance() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    MyThread myThread = new MyThread();
    Thread t1 = new Thread(myThread, "thread1");
    Thread t2 = new Thread(myThread, "thread2");
    Thread t3 = new Thread(myThread, "thread3");
    t1.start();
    t2.start();
    t3.start();
  }

  public static void printStackTrace() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    System.out.println(list);
  }

  public static void evaluate() {
    System.out.println("evaluate");
    Person person = new Person("bywin", 12);
    List<Integer> list =
        Arrays.asList(1, 2, 3, 4).stream().map(x -> x * 3).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    //    advance();
    //    printStackTrace();
    evaluate();
  }
}

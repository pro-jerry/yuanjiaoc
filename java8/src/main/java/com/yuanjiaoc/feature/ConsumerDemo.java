package com.yuanjiaoc.feature;

import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月16日
 */
public class ConsumerDemo {

  @Test
  public void testConsumer() {

    // 使用consumer接口实现方法.
    Consumer<String> consumer =
        new Consumer<String>() {
          @Override
          public void accept(String s) {
            System.out.println(s);
          }
        };

    Stream<String> stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
    stream.forEach(consumer);

    // ② 使用lambda表达式，forEach方法需要的就是一个Consumer接口
    stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
    Consumer<String> consumer1 = (s) -> System.out.println(s); // lambda表达式返回的就是一个Consumer接口
    stream.forEach(consumer1);

    // ③ 使用方法引用，方法引用也是一个consumer
    stream = Stream.of("aaa", "bbb", "ddd", "ccc", "fff");
    Consumer consumer2 = System.out::println;
    stream.forEach(consumer2);
    // 更直接的方式
    stream = Stream.of("aaa1", "bbb2", "ddd2", "ccc2", "fff2");
    stream.forEach(System.out::println);
  }
}

package com.yuanjiaoc.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月30日
 */
public class Java8Test3 {

  public void handlerConsumer(Integer number, Consumer<Integer> consumer) {
    consumer.accept(number);
  }

  @Test
  public void test1() {
    this.handlerConsumer(10000, (i) -> System.out.println(i));
  }

  public List<Integer> getNumberList(int num, Supplier<Integer> supplier) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      list.add(supplier.get());
    }
    return list;
  }

  @Test
  public void test2() {
    List<Integer> numberList = this.getNumberList(10, () -> new Random().nextInt(100));
    numberList.stream().forEach(System.out::println);
  }

  public String handlerString(String str, Function<String, String> func) {
    return func.apply(str);
  }

  @Test
  public void test3() {
    String str = this.handlerString("binghe", (s) -> s.toUpperCase());
    System.out.println(str);
  }

  public List<String> filterString(List<String> list, Predicate<String> predicate) {
    List<String> strList = new ArrayList<>();
    for (String str : list) {
      if (predicate.test(str)) {
        strList.add(str);
      }
    }
    return strList;
  }

  @Test
  public void test4() {
    List<String> list = Arrays.asList("Hello", "Lambda", "binghe", "lyz", "World");
    List<String> strList = this.filterString(list, (s) -> s.length() >= 5);
    strList.stream().forEach(System.out::println);
  }
}

package com.yuanjiaoc.feature;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月16日
 */
public class SupplierDemo {

  /** Supplier接口测试，supplier相当一个容器或者变量，可以存储值. */
  @Test
  public void testSupplier() {
    Supplier<Integer> supplier =
        new Supplier<Integer>() {
          @Override
          public Integer get() {
            return new Random().nextInt();
          }
        };
    System.out.println(supplier.get());
    System.out.println("********************");
    // ② 使用lambda表达式，
    supplier = () -> new Random().nextInt();
    System.out.println(supplier.get());
    System.out.println("********************");
    // ③ 使用方法引用
    Supplier<Double> supplier1 = Math::random;
    System.out.println(supplier1.get());
  }

  @Test
  public void test_Supplier2() {
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    Optional<Integer> frist = stream.filter(i -> i > 5).findFirst();
    System.out.println(frist.orElse(1));
    System.out.println(frist.orElse(7));

    Supplier<Integer> supplier =
        new Supplier<Integer>() {
          @Override
          public Integer get() {
            return new Random().nextInt();
          }
        };
    System.out.println(frist.orElseGet(supplier));
  }
}

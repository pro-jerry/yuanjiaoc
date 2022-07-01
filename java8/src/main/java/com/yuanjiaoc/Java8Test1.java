package com.yuanjiaoc;

import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * 匿名表达式.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月29日
 */
public class Java8Test1 {

  /** 无参，无返回值，Lambda体只有一条语句 */
  @Test
  public void test1() {
    Runnable r = () -> System.out.println("Hello Lambda");
    new Thread(r).start();
  }

  /** Lambda表达式需要一个参数，并且无返回值 */
  @Test
  public void test2() {
    Consumer<String> consumer = (x) -> System.out.println(x);
    consumer.accept("Hello Lambda");
  }

  /** Lambda只需要一个参数时，参数的小括号可以省略 */
  @Test
  public void test3() {
    Consumer<String> consumer = x -> System.out.println(x);
    consumer.accept("Hello Lambda");
  }

  @Test
  public void test4() {
    Comparator<Integer> comparator =
        (x, y) -> {
          System.out.println("函数式接口");
          return Integer.compare(x, y);
        };
    comparator.compare(1, 2);
  }

  @Test
  public void test5() {
    Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
  }

  public String handlerString(MyFunc<String> myFunc, String str) {

    return myFunc.getValue(str);
  }

  @Test
  public void test6() {
    String str = handlerString((s) -> s.toUpperCase(), "binghe");
    System.out.println(str);
  }
}

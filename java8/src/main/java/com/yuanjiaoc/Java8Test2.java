package com.yuanjiaoc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月30日
 */
public class Java8Test2 {

  public String stringHandler(String str, MyFunction myFunction) {
    return myFunction.getValue(str);
  }

  public void operate(Long num1, Long num2, MyFuncTR<Long, Long> myFuncTR) {
    System.out.println(myFuncTR.getValue(num1, num2));
  }

  protected List<Employee> employees =
      Arrays.asList(
          new Employee("张三", 18, 9999.99),
          new Employee("李四", 38, 5555.55),
          new Employee("王五", 60, 6666.66),
          new Employee("赵六", 8, 7777.77),
          new Employee("田七", 58, 3333.33));

  @Test
  public void test1() {
    Collections.sort(
        employees,
        (e1, e2) -> {
          if (e1.getAge() == e2.getAge()) {
            return e1.getName().compareTo(e2.getName());
          }
          return -Integer.compare(e1.getAge(), e2.getAge());
        });
    employees.stream().forEach(System.out::println);
  }

  @Test
  public void test2() {
    String value = stringHandler("binghe", (s) -> s.toUpperCase());
    System.out.println(value);
  }

  @Test
  public void test3() {
    String value = stringHandler("binghe", (s) -> s.substring(1, 3));
    System.out.println(value);
  }

  @Test
  public void test4() {
    operate(100L, 200L, (x, y) -> x + y);
  }

  @Test
  public void test5() {
    operate(100L, 200L, (x, y) -> x * y);
  }
}

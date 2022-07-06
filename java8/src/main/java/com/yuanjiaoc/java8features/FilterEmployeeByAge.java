package com.yuanjiaoc.java8features;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月29日
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {

  @Override
  public boolean filter(Employee employee) {
    return employee.getAge() > 30;
  }
}

package com.yuanjiaoc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月29日
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {

  @Override
  public boolean filter(Employee employee) {
    return employee.getSalary() >= 5000;
  }
}

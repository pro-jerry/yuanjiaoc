package com.yuanjiaoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Hello world! */
public class Java8Test0 {

  protected List<Employee> employees =
      Arrays.asList(
          new Employee("张三", 18, 9999.99),
          new Employee("李四", 38, 5555.55),
          new Employee("王五", 60, 6666.66),
          new Employee("赵六", 16, 7777.77),
          new Employee("田七", 18, 3333.33));

  public List<Employee> filterEmployeesByAge(List<Employee> list) {
    List<Employee> employees = new ArrayList<>();
    for (Employee e : list) {
      if (e.getAge() >= 30) {
        employees.add(e);
      }
    }
    return employees;
  }

  // 优化方式一
  public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
    List<Employee> employees = new ArrayList<>();
    for (Employee e : list) {
      if (myPredicate.filter(e)) {
        employees.add(e);
      }
    }
    return employees;
  }

  @Test
  public void test3() {
    List<Employee> employeeList = filterEmployeesByAge(this.employees);
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }

  @Test
  public void test4() {
    List<Employee> employeeList = this.filterEmployee(this.employees, new FilterEmployeeByAge());
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }

  @Test
  public void test5() {
    List<Employee> employeeList = this.filterEmployee(this.employees, new FilterEmployeeBySalary());
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }

  @Test
  public void test6() {
    List<Employee> employeeList =
        this.filterEmployee(
            this.employees,
            new MyPredicate<Employee>() {
              @Override
              public boolean filter(Employee employee) {
                return employee.getAge() >= 30;
              }
            });
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }

  @Test
  public void test7() {
    List<Employee> employeeList =
        this.filterEmployee(
            this.employees,
            new MyPredicate<Employee>() {
              @Override
              public boolean filter(Employee employee) {
                return employee.getSalary() >= 5000;
              }
            });
    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }

  @Test
  public void test8() {
    filterEmployee(this.employees, (e) -> e.getAge() >= 30).forEach(System.out::println);
  }

  @Test
  public void test9() {
    filterEmployee(this.employees, (e) -> e.getSalary() >= 5000).forEach(System.out::println);
  }

  @Test
  public void test10() {
    employees.stream().filter(x -> x.getAge() > 30).forEach(System.out::println);
  }

  @Test
  public void test11() {
    employees.stream().filter(x -> x.getSalary() > 5000).limit(2).forEach(System.out::println);
  }

  @Test
  public void test12() {
    employees.stream()
        .filter(x -> x.getSalary() > 5000)
        .map(Employee::getName)
        .forEach(System.out::println);
  }
}

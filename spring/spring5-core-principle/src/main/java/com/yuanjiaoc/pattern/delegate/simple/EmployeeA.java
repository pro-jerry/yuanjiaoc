package com.yuanjiaoc.pattern.delegate.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class EmployeeA implements IEmployee {

  @Override
  public void doing(String command) {
    System.out.println("我是员工A，我现在开始干" + command + "工作");
  }
}

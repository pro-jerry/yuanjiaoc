package com.yuanjiaoc.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Leader implements IEmployee {

  private final Map<String, IEmployee> targets = new HashMap<String, IEmployee>();

  public Leader() {
    targets.put("加密", new EmployeeA());
    targets.put("登录", new EmployeeB());
  }

  @Override
  public void doing(String command) {
    targets.get(command).doing(command);
  }
}

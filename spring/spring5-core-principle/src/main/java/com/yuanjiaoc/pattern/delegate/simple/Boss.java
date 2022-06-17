package com.yuanjiaoc.pattern.delegate.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Boss {

  public void command(String command, Leader leader) {
    leader.doing(command);
  }
}

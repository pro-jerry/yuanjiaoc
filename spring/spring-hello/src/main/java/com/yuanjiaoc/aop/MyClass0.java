package com.yuanjiaoc.aop;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月04日
 */
@Component
public class MyClass0 {

  @MyAnnotation
  public int div(int a, int b) {
    return a + b;
  }

  public String write(Pen pen) {
    return pen.writeText();
  }
}

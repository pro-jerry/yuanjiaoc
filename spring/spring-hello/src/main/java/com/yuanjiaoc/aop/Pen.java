package com.yuanjiaoc.aop;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月04日
 */
@Component
@MyAnnotation
public class Pen {
  public String writeText() {
    return "Hello world";
  }
}

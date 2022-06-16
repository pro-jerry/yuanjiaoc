package com.yuanjiaoc.pattern.prototype.deep;

import java.io.Serializable;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class JinGuBang implements Serializable {
  public float h = 100;
  public float d = 10;

  public void big() {
    this.d *= 2;
    this.h *= 2;
  }

  public void small() {
    this.d /= 2;
    this.h /= 2;
  }
}

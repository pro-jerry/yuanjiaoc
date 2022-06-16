package com.yuanjiaoc.pattern.singleton.register;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public enum EnumSingleton {
  INSTANCE;
  private Object data;

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static EnumSingleton getInstance() {
    return INSTANCE;
  }
}

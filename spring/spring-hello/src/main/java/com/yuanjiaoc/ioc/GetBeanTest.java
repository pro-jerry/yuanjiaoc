package com.yuanjiaoc.ioc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
public abstract class GetBeanTest {

  public abstract User getBean();

  public void showMe() {
    this.getBean().showMe();
  }
}

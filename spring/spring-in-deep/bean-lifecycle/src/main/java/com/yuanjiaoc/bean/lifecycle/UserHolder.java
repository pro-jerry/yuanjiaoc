package com.yuanjiaoc.bean.lifecycle;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.env.Environment;

/**
 * User Holder 类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月22日
 */
@Data
public class UserHolder {

  private User user;

  private Integer number;

  private String description;

  private ClassLoader classLoader;

  private BeanFactory beanFactory;

  private String beanName;

  private Environment environment;

  public UserHolder(User user) {
    this.user = user;
  }

  public UserHolder() {}

  /** 自定义初始化方法 */
  public void init() {
    // initPostConstruct V5 -> afterPropertiesSet V6
    this.description = "The user holder V6";
    System.out.println("init() = " + description);
  }

  public void destroy() throws Exception {
    // preDestroy : The user holder V10
    this.description = "The user holder V11";
    System.out.println("destroy() = " + description);
  }

  public void doDestroy() {
    // destroy : The user holder V11
    this.description = "The user holder V12";
    System.out.println("doDestroy() = " + description);
  }
}

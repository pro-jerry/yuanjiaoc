package com.yuanjiaoc.bean.lifecycle;

import javax.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * User Holder 类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月22日
 */
@Data
public class UserHolder
    implements BeanNameAware,
        BeanClassLoaderAware,
        BeanFactoryAware,
        EnvironmentAware,
        InitializingBean,
        SmartInitializingSingleton,
        DisposableBean {

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

  @PostConstruct
  public void initPostConstruct() {
    // postProcessBeforeInitialization V3 -> initPostConstruct V4
    this.description = "The user holder V4";
    System.out.println("initPostConstruct() = " + description);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    this.description = "The user holder V5";
    System.out.println("afterPropertiesSet() = " + description);
  }

  /** 自定义初始化方法 */
  public void init() {
    // initPostConstruct V5 -> afterPropertiesSet V6
    this.description = "The user holder V6";
    System.out.println("init() = " + description);
  }

  @Override
  public void afterSingletonsInstantiated() {
    // postProcessAfterInitialization V7 -> afterSingletonsInstantiated V8
    this.description = "The user holder V8";
    System.out.println("afterSingletonsInstantiated() = " + description);
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

  public String toString() {
    return "UserHolder{"
        + "user="
        + user
        + ", number="
        + number
        + ", description='"
        + description
        + '\''
        + ", beanName='"
        + beanName
        + '\''
        + '}';
  }

  public void setBeanClassLoader(ClassLoader classLoader) {
    this.classLoader = classLoader;
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  @Override
  public void setBeanName(String name) {
    this.beanName = name;
  }
}

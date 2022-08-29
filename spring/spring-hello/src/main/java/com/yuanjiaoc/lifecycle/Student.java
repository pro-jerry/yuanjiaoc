package com.yuanjiaoc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月26日
 */
public class Student implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

  private String name;
  private String address;
  private int phone;
  private BeanFactory beanFactory;
  private String beanName;

  public Student() {
    System.out.println("【构造器】调用Student的构造器实例化 ---6");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("【注入属性】name ---8");
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    System.out.println("【注入属性】address---9");
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    System.out.println("【注入属性】phone---10");
    this.phone = phone;
  }

  // 这是BeanFactoryAware接口方法
  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.out.println("【BeanFactoryAware接口】调用setBeanFactory方法---12");
    this.beanFactory = beanFactory;
  }

  // 这是BeanNameAware接口方法
  @Override
  public void setBeanName(String name) {
    System.out.println("【BeanNameAware接口】调用setBeanName方法---11");
    this.beanName = name;
  }

  // 这是DiposibleBean接口方法
  @Override
  public void destroy() throws Exception {
    System.out.println("【DiposibleBean接口】调用destroy方法");
  }

  // 这是InitializingBean接口方法
  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("【InitializingBean接口】调用afterPropertiesSet方法---14");
  }

  // 通过<bean>的init-method属性指定的初始化方法
  public void myInit() {
    System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法---15");
  }

  // 通过<bean>的destroy-method属性指定的初始化方法
  public void myDestory() {
    System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
  }

  @Override
  public String toString() {
    return "Student{"
        + "name='"
        + name
        + '\''
        + ", address='"
        + address
        + '\''
        + ", phone="
        + phone
        + ", beanFactory="
        + beanFactory
        + ", beanName='"
        + beanName
        + '\''
        + '}';
  }
}

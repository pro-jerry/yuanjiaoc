package com.yuanjiaoc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 商品的FactoryBean，测试FactoryBean.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月24日
 */
public class PersonFactoryBean implements FactoryBean<Person> {

  /**
   * 返回一个Person对象,这个对象会被注册到Spring容器中.
   *
   * @return
   * @throws Exception
   */
  @Override
  public Person getObject() throws Exception {
    return new Person();
  }

  @Override
  public Class<?> getObjectType() {
    return Person.class;
  }

  /**
   * bean是否为单例,true 是,false 否
   *
   * @return
   */
  @Override
  public boolean isSingleton() {
    return true;
  }
}

package com.yuanjiaoc.bean;

import com.yuanjiaoc.common.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.support.AbstractBeanDefinition}的派生类构建
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
public class AbstractBeanDefinitionCreationDemo {

  public static void main(String[] args) {

    // 通过 AbstractBeanDefinition 以及派生类
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    // 设置Bean类型
    genericBeanDefinition.setBeanClass(User.class);
    // 通过 MutablePropertyValues 批量操作属性
    MutablePropertyValues propertyValues = new MutablePropertyValues();
  }
}

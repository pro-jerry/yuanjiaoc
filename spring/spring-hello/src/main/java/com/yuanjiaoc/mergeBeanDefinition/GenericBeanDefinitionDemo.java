package com.yuanjiaoc.mergeBeanDefinition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月17日
 */
public class GenericBeanDefinitionDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    // 父BeanDefinition
    GenericBeanDefinition rootBeanDefinition = new GenericBeanDefinition();
    rootBeanDefinition.setBeanClass(SuperUser.class);
    // 设置参数
    MutablePropertyValues propertyValues = new MutablePropertyValues();
    propertyValues.addPropertyValue("address", "地址");

    rootBeanDefinition.setPropertyValues(propertyValues);

    // 子BeanDefinition
    GenericBeanDefinition childBeanDefinition = new GenericBeanDefinition();
    childBeanDefinition.setBeanClass(User.class);
    // 设置构造参数
    ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
    argumentValues.addIndexedArgumentValue(0, "我就是我");
    argumentValues.addIndexedArgumentValue(1, 18);

    childBeanDefinition.setConstructorArgumentValues(argumentValues);
    childBeanDefinition.setParentName("superUser");
    // 类型相同时 以子类为主
    childBeanDefinition.setPrimary(true);

    context.registerBeanDefinition("superUser", rootBeanDefinition);
    context.registerBeanDefinition("user", childBeanDefinition);

    context.refresh();
    User user = context.getBean("user", User.class);
    System.out.println(user);

    SuperUser superUser = context.getBean("superUser", SuperUser.class);
    System.out.println(superUser);
    context.close();
  }
}

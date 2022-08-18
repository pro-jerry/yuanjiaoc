package com.yuanjiaoc.beanpropertyinit;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月18日
 */
public class BeanPostProcessDemo {

  public static void main(String[] args) {
    BeanDefinitionBuilder beanDefinitionBuilder =
        BeanDefinitionBuilder.genericBeanDefinition(User.class);
    beanDefinitionBuilder.addPropertyValue("name", "wojiushiwo");
    beanDefinitionBuilder.addPropertyValue("age", 20);

    // 获取 AbstractBeanDefinition
    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    // 附加属性
    beanDefinition.setAttribute("name", "我是附加属性");
    // 当前 BeanDefinition 来自哪里（辅助作用）
    beanDefinition.setSource(BeanPostProcessDemo.class);

    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.addBeanPostProcessor(new MyInstantiationBeanPostProcessor());
    // 注册 User 的 BeanDefinition
    beanFactory.registerBeanDefinition("user", beanDefinition);
    User user = beanFactory.getBean("user", User.class);
    System.out.println(user);
  }
}
